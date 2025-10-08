package org.mustapha.digitalhospitaljee.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import org.mustapha.digitalhospitaljee.model.Patient;
import org.mustapha.digitalhospitaljee.service.PatientService;

import java.io.IOException;
import java.util.List;

@WebServlet("/patients")
public class PatientServlet extends HttpServlet {

    private PatientService patientService;

    @Override
    public void init() throws ServletException {
        patientService = new PatientService();
        Patient testPatient = new Patient("John Doe", 30);// create patient for test
        patientService.savePatient(testPatient);// save the patient in db
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Patient> patients = patientService.getAllPatients();
        req.setAttribute("patients", patients);
        req.getRequestDispatcher("/WEB-INF/view/patient.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        patientService.close();
    }
}
