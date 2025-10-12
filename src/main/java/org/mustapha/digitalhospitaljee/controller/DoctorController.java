package org.mustapha.digitalhospitaljee.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mustapha.digitalhospitaljee.Exceptions.BusinessException;
import org.mustapha.digitalhospitaljee.model.Doctor;
import org.mustapha.digitalhospitaljee.service.impl.DoctorServiceImpl;

import java.io.IOException;

@WebServlet("/doctors")
public class DoctorController extends HttpServlet {

    private DoctorServiceImpl doctorService;

    @Override
    public void init() throws ServletException {
        try {
            doctorService = new DoctorServiceImpl();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Error initializing DoctorService", e);
        }
    }

    // display the form
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/doctor.jsp").forward(req, resp);
    }

    // send the data
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String ageParam = req.getParameter("age");
        int age = 0;

        if (ageParam != null && !ageParam.trim().isEmpty()) {
            try {
                age = Integer.parseInt(ageParam);
            } catch (NumberFormatException e) {
                req.setAttribute("error", "Age must be a number");
                req.getRequestDispatcher("/WEB-INF/view/doctor.jsp").forward(req, resp);
                return;
            }
        }

        // إنشاء كائن Doctor
        Doctor doctor = new Doctor();
        doctor.setName(name);
        doctor.setAge(age);

        try {
            doctorService.createDoctor(doctor); // استدعاء الخدمة
            req.setAttribute("message", "Doctor created successfully!");
            req.getRequestDispatcher("/WEB-INF/view/success.jsp").forward(req, resp);
        } catch (BusinessException e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/view/doctor.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("error", "Unexpected error: " + e.getMessage());
            req.getRequestDispatcher("/WEB-INF/view/doctor.jsp").forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        // إذا احتجت لإغلاق أي موارد في المستقبل
    }
}
