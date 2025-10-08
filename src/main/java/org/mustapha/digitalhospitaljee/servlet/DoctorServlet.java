package org.mustapha.digitalhospitaljee.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mustapha.digitalhospitaljee.model.Doctor;
import org.mustapha.digitalhospitaljee.service.DoctorService;

import java.io.IOException;

@WebServlet("/doctors")
public class DoctorServlet extends HttpServlet {
    private DoctorService doctorService;

    @Override
    public void init() throws ServletException {
        try {
            doctorService = new DoctorService();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("error in level of init methode", e);
        }
    }


    // 🔵 Handle GET (for testing or form view)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/doctor.jsp").forward(req, resp);

    }

    // 🟢 Handle POST (form submission)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ageParam = req.getParameter("age");
        String name = req.getParameter("name");
        int age = 0;
        if (ageParam != null && !ageParam.trim().isEmpty()) {
            try {
                age = Integer.parseInt(ageParam);
            } catch (NumberFormatException e) {
                age = 0;
            }
        }
        Doctor doctor = new Doctor();
        doctor.setAge(age);
        doctor.setName(name);

        doctorService.createDocotr(doctor);
        req.getRequestDispatcher("/WEB-INF/view/success.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        doctorService.close();
    }
}

