/**
 * The controller or Servlet it the class that is responsible to get data from the front to db and verse virsa
 *  note: doGet when is methode of request is get-like get that page
 *  note : doPost when is the methode or request is post -like from of info
 */

package org.mustapha.digitalhospitaljee.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import org.mustapha.digitalhospitaljee.model.Patient;
import org.mustapha.digitalhospitaljee.service.impl.PatientServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/patients") // this is the url path
public class PatientServlet extends HttpServlet {

    private PatientServiceImpl patientService;

    @Override
    public void init() throws ServletException {
        patientService = new PatientServiceImpl();
//        Patient testPatient = new Patient("John Doe", 30);// create patient for test
//        patientService.savePatient(testPatient);// save the patient in db
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Patient> patients = patientService.getAllPatients();
        req.setAttribute("patients", patients);
        req.getRequestDispatcher("/WEB-INF/view/list.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        patientService.close();
    }
}
