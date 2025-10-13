package org.mustapha.digitalhospitaljee.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import org.mustapha.digitalhospitaljee.Repository.PatientRepository;
import org.mustapha.digitalhospitaljee.Repository.impl.PatientRepositoryImpl;
import org.mustapha.digitalhospitaljee.model.Patient;
import org.mustapha.digitalhospitaljee.service.PatientService;
import org.mustapha.digitalhospitaljee.service.impl.PatientServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/patient/dashboard")
//@WebServlet(urlPatterns = {"/patient/dashboard", "/patients"})
public class PatientServlet extends HttpServlet {

    private PatientRepository patientRepository;
    private PatientService patientService;

    @Override
    public void init() throws ServletException {
        patientRepository = new PatientRepositoryImpl();
        patientService = new PatientServiceImpl(patientRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        switch (action == null ? "" : action) {
            case "addPatient":
                req.getRequestDispatcher("/WEB-INF/view/patient/add.jsp").forward(req, resp);
                break;
            case "listPatients":
                List<Patient> patients = patientService.getAllPatients();
                req.setAttribute("patients", patients);
                req.getRequestDispatcher("/WEB-INF/view/patient/list.jsp").forward(req, resp);
                break;
            default:
                req.getRequestDispatcher("/WEB-INF/view/assets/dashboards/patient-dashboard.jsp").forward(req, resp);
                break;
        }
    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//
//        String action = req.getParameter("action");
//
//        switch (action == null ? "" : action) {
//            case "addPatient":
//                String name = req.getParameter("name");
//                String email = req.getParameter("email");
//                String phone = req.getParameter("phone");
//
//                Patient patient = new Patient();
//                patient.setName(name);
//                patient.setEmail(email);
//                patient.setPhone(phone);
//
//                patientService.addPatient(patient);
//                resp.sendRedirect(req.getContextPath() + "/patient/dashboard?action=listPatients");
//                break;
//
//            case "deletePatient":
//                int id = Integer.parseInt(req.getParameter("id"));
//                patientService.deletePatient(id);
//                resp.sendRedirect(req.getContextPath() + "/patient/dashboard?action=listPatients");
//                break;
//
//            default:
//                resp.sendRedirect(req.getContextPath() + "/patient/dashboard");
//                break;
//        }
//    }
}
