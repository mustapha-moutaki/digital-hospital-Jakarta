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
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@WebServlet("/consultations/*")
public class ConsultationController extends HttpServlet {

    private RoomService roomService;
    private ConsultationService consultationService;
    private PatientService patientService;
    private DoctorService doctorService;
    private DepartmentService departmentService;

    @Override
    public void init(ServletConfig config) throws ServletException {
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
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String role = (String) session.getAttribute("role");
        String action = req.getParameter("action");

        try {
            if ("availableTimes".equalsIgnoreCase(action)) {
                Long doctorId = Long.parseLong(req.getParameter("doctorId"));
                LocalDate date = LocalDate.parse(req.getParameter("date"));
                List<String> availableTimes = consultationService.getAvailableTimesForDoctor(doctorId, date);
                resp.setContentType("application/json");
                resp.getWriter().write(new Gson().toJson(availableTimes));
                return;
            }

            if ("availableRooms".equalsIgnoreCase(action)) {
                LocalDate date = LocalDate.parse(req.getParameter("date"));
                LocalTime time = LocalTime.parse(req.getParameter("time"));
                LocalDateTime startTime = LocalDateTime.of(date, time);
                List<Room> availableRooms = roomService.getAvailableRooms(startTime);
                resp.setContentType("application/json");
                resp.getWriter().write(new Gson().toJson(availableRooms));
                return;
            }

            if ("add".equalsIgnoreCase(action)) {
                List<Patient> patients = patientService.getAllPatients().stream()
                        .filter(p -> "Patient".equalsIgnoreCase(p.getRole())).toList();
                List<Doctor> doctors = doctorService.getAllDoctors();
                List<Room> rooms = roomService.roomList(); // جلب كل الغرف بدون فلترة
                List<Department> departments = departmentService.departmentList();

                req.setAttribute("patients", patients);
                req.setAttribute("doctors", doctors);
                req.setAttribute("rooms", rooms);
                req.setAttribute("departments", departments);

                req.getRequestDispatcher("/WEB-INF/view/consultation/add.jsp").forward(req, resp);
            } else {
                List<Consultation> consultations;
                switch (role) {
                    case "Admin":
                        consultations = consultationService.consultationList();
                        break;
                    case "Doctor":
                        Long doctorId = (Long) session.getAttribute("currentUserId");
                        consultations = consultationService.consultationList().stream()
                                .filter(c -> c.getDoctor() != null && c.getDoctor().getId().equals(doctorId))
                                .toList();
                        break;
                    case "Patient":
                        Long patientId = (Long) session.getAttribute("currentUserId");
                        consultations = consultationService.consultationList().stream()
                                .filter(c -> c.getPatient() != null && c.getPatient().getId().equals(patientId))
                                .toList();
                        break;
                    default:
                        consultations = List.of();
                }
                req.setAttribute("consultations", consultations);
                req.getRequestDispatcher("/WEB-INF/view/consultation/consultation-list.jsp").forward(req, resp);
            }

        } catch (ConsultationException e) {
            resp.getWriter().println("Error: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action = req.getParameter("action");
            if ("createConsultation".equalsIgnoreCase(action)) {
                Long patientId = Long.parseLong(req.getParameter("patientId"));
                Patient patient = patientService.findById(patientId);

                Long doctorId = Long.parseLong(req.getParameter("doctorId"));
                Doctor doctor = doctorService.findById(doctorId);

                Long roomId = Long.parseLong(req.getParameter("roomId"));
                Room room = roomService.getRoomById(roomId);

                LocalDate date = LocalDate.parse(req.getParameter("consultationDate"));
                LocalTime time = LocalTime.parse(req.getParameter("startTime"));
                LocalDateTime startTime = LocalDateTime.of(date, time);

                Consultation consultation = new Consultation(
                        patient,
                        doctor,
                        room,
                        ConsultationStatus.PENDING,
                        startTime,
                        ""
                );

                consultationService.create(consultation);
            }

            resp.sendRedirect(req.getContextPath() + "/consultations?action=list");

        } catch (Exception e) {
            resp.getWriter().println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
