package org.mustapha.digitalhospitaljee.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.mustapha.digitalhospitaljee.Exceptions.ConsultationException;
import org.mustapha.digitalhospitaljee.Repository.*;
import org.mustapha.digitalhospitaljee.Repository.impl.*;
import org.mustapha.digitalhospitaljee.model.*;
import org.mustapha.digitalhospitaljee.model.enums.ConsultationStatus;
import org.mustapha.digitalhospitaljee.service.*;
import org.mustapha.digitalhospitaljee.service.impl.*;

import com.google.gson.Gson;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

@WebServlet("/consultations/*")
public class ConsultationController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(ConsultationController.class.getName());

    private RoomService roomService;
    private ConsultationService consultationService;
    private PatientService patientService;
    private DoctorService doctorService;
    private DepartmentService departmentService;
    private Gson gson;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        RoomRepository roomRepo = new RoomRepositoryImp();
        ConsultationRepository conRepo = new ConsultationRepositoryImpl();
        PatientRepository patRepo = new PatientRepositoryImpl();
        DoctorRepository docRepo = new DoctorRepositoryImpl();
        DepartmentRepository depaRepo = new DepartmentRepositoryImpl();

        consultationService = new ConsultationServiceImpl(conRepo);
        roomService = new RoomServiceImpl(roomRepo, consultationService);
        patientService = new PatientServiceImpl(patRepo);
        doctorService = new DoctorServiceImpl(docRepo);
        departmentService = new DepartmentServiecImpl(depaRepo);
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        String action = req.getParameter("action");
        if (action == null || action.equalsIgnoreCase("list")) {
            List<Consultation> consultations = consultationService.consultationList();
            req.setAttribute("consultations", consultations);
            req.getRequestDispatcher("/WEB-INF/view/consultation/consultation-list.jsp").forward(req, resp);
            return;
        }

        if (action.equalsIgnoreCase("add")) {
            try {
                List<Patient> patients = patientService.getAllPatients().stream()
                        .filter(p -> "Patient".equalsIgnoreCase(p.getRole()))
                        .toList();

                List<Doctor> doctors = doctorService.getAllDoctors();
                List<Department> departments = departmentService.departmentList();
                List<Room> rooms = roomService.roomList();

                List<String> times = new ArrayList<>();
                for (int h = 9; h < 17; h++) {
                    times.add(String.format("%02d:00", h));
                    times.add(String.format("%02d:30", h));
                }

                req.setAttribute("patients", patients);
                req.setAttribute("doctors", doctors);
                req.setAttribute("departments", departments);
                req.setAttribute("times", times);
                req.setAttribute("rooms", rooms);

                req.getRequestDispatcher("/WEB-INF/view/consultation/add.jsp").forward(req, resp);

            } catch (Exception e) {
                throw new ServletException("Failed to load add consultation page: " + e.getMessage(), e);
            }
        } else if (action.equalsIgnoreCase("delete")) {
            try {
                long id = Long.parseLong(req.getParameter("id"));
                consultationService.delete(id);

                // Redirect to the list page after deletion
                resp.sendRedirect(req.getContextPath() + "/consultations?action=list");

            } catch (Exception e) {
                throw new ServletException("Failed to delete consultation: " + e.getMessage(), e);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("createConsultation".equals(action)) {

            try {
                Long patientId = Long.parseLong(request.getParameter("patientId"));
                Long doctorId = Long.parseLong(request.getParameter("doctorId"));
                Long roomId = Long.parseLong(request.getParameter("roomId"));

                String dateStr = request.getParameter("consultationDate");
                String timeStr = request.getParameter("startTime");

                if(dateStr == null || dateStr.isEmpty() || timeStr == null || timeStr.isEmpty()) {
                    throw new ServletException("Date and Time must be provided!");
                }

                LocalDate date = LocalDate.parse(dateStr);
                LocalTime time = LocalTime.parse(timeStr);
                LocalDateTime startTime = LocalDateTime.of(date, time);

                Patient patient = patientService.findById(patientId);
                Doctor doctor = doctorService.findById(doctorId);
                Room room = roomService.getRoomById(roomId);

                Consultation consultation = new Consultation();
                consultation.setConsultationStatus(ConsultationStatus.PENDING);
                consultation.setDateTime(LocalDateTime.now());// ceated time
                consultation.setStartTime(startTime);      // consulation actual time
                consultation.setPatient(patient);
                consultation.setDoctor(doctor);
                consultation.setRoom(room);
                consultation.setReport("N/A");


                consultationService.create(consultation);

                response.sendRedirect(request.getContextPath() + "/consultations?action=list");

            } catch (Exception e) {
                throw new ServletException("Failed to create Consultation", e);
            }
        }
    }




}
