/**
 * The controller or Servlet it the class that is responsible to get data from the front to db and verse virsa
 *  note: doGet when is methode of request is get-like get that page
 *  note : doPost when is the methode or request is post -like from of info
 */

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

@WebServlet("/patient/dashboard") // this is the url path
public class PatientServlet extends HttpServlet {

    private PatientRepository patientRepository;

    @Override
    public void init() throws ServletException {
        patientRepository = new PatientRepositoryImpl();
        PatientService patientService = new PatientServiceImpl(patientRepository);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }



}
