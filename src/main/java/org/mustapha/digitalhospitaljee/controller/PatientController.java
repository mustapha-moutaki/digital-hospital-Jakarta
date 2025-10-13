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

@WebServlet("/patient/*")
//@WebServlet(urlPatterns = {"/patient/dashboard", "/patients"})
public class PatientController extends HttpServlet {

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
            case "add":
                req.getRequestDispatcher("/WEB-INF/view/patient/add.jsp").forward(req, resp);
                break;
            default:
                List<Patient> patients = patientService.getAllPatients();
                req.setAttribute("patients", patients);
                req.getRequestDispatcher("/WEB-INF/view/patient/list.jsp").forward(req, resp);
        }
    }
//
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
                patient.setPassword(password);
                patient.setTall(tall);
                patient.setWeight(weight);

                patientService.craete(patient);
                resp.sendRedirect(req.getContextPath() + "/patient/list.jsp");
        }
    }
}
