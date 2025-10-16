package org.mustapha.digitalhospitaljee.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import org.hibernate.sql.Update;
import org.mindrot.jbcrypt.BCrypt;
import org.mustapha.digitalhospitaljee.Repository.DoctorRepository;
import org.mustapha.digitalhospitaljee.Repository.PatientRepository;
import org.mustapha.digitalhospitaljee.Repository.impl.DoctorRepositoryImpl;
import org.mustapha.digitalhospitaljee.Repository.impl.PatientRepositoryImpl;
import org.mustapha.digitalhospitaljee.model.Doctor;
import org.mustapha.digitalhospitaljee.model.Patient;
import org.mustapha.digitalhospitaljee.service.DoctorService;
import org.mustapha.digitalhospitaljee.service.PatientService;
import org.mustapha.digitalhospitaljee.service.impl.DoctorServiceImpl;
import org.mustapha.digitalhospitaljee.service.impl.PatientServiceImpl;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@WebServlet("/patient/*")
//@WebServlet(urlPatterns = {"/patient/dashboard", "/patients"})
public class PatientController extends HttpServlet {

    private PatientRepository patientRepository;
    private PatientService patientService;

    private DoctorService doctorService;

    @Override
    public void init() throws ServletException {
        patientRepository = new PatientRepositoryImpl();
        patientService = new PatientServiceImpl(patientRepository);

        DoctorRepository doctorRepository = new DoctorRepositoryImpl();
        doctorService = new DoctorServiceImpl(doctorRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        switch (action) {
            case "add":
                req.getRequestDispatcher("/WEB-INF/view/patient/add.jsp").forward(req, resp);
                break;
            case "edit":
                long id = Long.parseLong(req.getParameter("id"));
                Patient patient  = patientService.findById(id);
                req.setAttribute("patientInfo", patient);
                req.getRequestDispatcher("/WEB-INF/view/patient/update.jsp").forward(req, resp);
            break;
            case "delete":
                long patientId = Long.parseLong(req.getParameter("id"));

                patientService.delete(patientId);
                String messagesucess = "the patient delete successfully";

                req.setAttribute("message", messagesucess);
                req.getRequestDispatcher("WEB-INF/view/assets/success/successMessage.jsp").forward(req, resp);
                break;


            default:
                List<Patient> patients;
//                if(user.getRole.equlas("Admin")){
                    patients = patientService.getAllPatients();
//                }else if(user.getRole.equals("Doctor")){
//                    patients = patientService.getAllByDoctorId(user.getid());
//                }else{
////                   patients = Collections.emptyList();
//                }

                req.setAttribute("patients", patients);
                req.getRequestDispatcher("/WEB-INF/view/patient/list.jsp").forward(req, resp);

        }

    }
//
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "addPatient":
                String firstname = req.getParameter("firstName");
                String lastname = req.getParameter("lastName");
                String email = req.getParameter("email");
                String password = req.getParameter("password");
                long tall = Long.parseLong(req.getParameter("tall"));
                long weight = Long.parseLong(req.getParameter("weight")) ;

                Patient patient = new Patient();
                patient.setFirstName(firstname);
                patient.setLastname(lastname);
                patient.setEmail(email);
                // hashing password
                String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt());
                patient.setPassword(hashPassword);
                patient.setRole("Patient");
                patient.setTall(tall);
                patient.setWeight(weight);

                patientService.craete(patient);
                resp.sendRedirect(req.getContextPath() + "/patient/list");

            break;

            case "update":
                // because it's update we should mention id too
                String id = req.getParameter("id");
                String firstnameParam = req.getParameter("firstName");
                String lastnameParam = req.getParameter("lastName");
                String emailParam = req.getParameter("email");
                String passwordParam = req.getParameter("password");


                String tallParam = req.getParameter("tall");
                String weightParam = req.getParameter("weight");

                if(tallParam == null || tallParam.isEmpty()){
                    throw new ServletException("tall is required");
                }
                Patient updatedpatient = new Patient();

                long updatedId = Long.parseLong(id);

                updatedpatient.setId(updatedId);
                updatedpatient.setFirstName(firstnameParam);
                updatedpatient.setLastname(lastnameParam);
                updatedpatient.setEmail(emailParam);
                updatedpatient.setPassword(passwordParam);

                double updatedTall = Double.parseDouble(tallParam);
                double updatedWeight = Double.parseDouble((weightParam));

                updatedpatient.setTall(updatedTall);
                updatedpatient.setWeight(updatedWeight);

                patientService.update(updatedpatient);
                String successmessage = "the patient udpated successfully";
                req.setAttribute("message", successmessage);
                req.getRequestDispatcher("/WEB-INF/view/assets/success/successMessage.jsp").forward(req, resp);
                break;


        }



    }
}
