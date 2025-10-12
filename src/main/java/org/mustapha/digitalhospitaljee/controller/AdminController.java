package org.mustapha.digitalhospitaljee.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mustapha.digitalhospitaljee.Repository.AdminRepository;
import org.mustapha.digitalhospitaljee.Repository.impl.AdminRepositoryImpl;
import org.mustapha.digitalhospitaljee.service.AdminService;
import org.mustapha.digitalhospitaljee.service.impl.AdminServiceImpl;

import java.io.IOException;

@WebServlet("/admin/dashboard")
public class AdminController extends HttpServlet {

    private AdminService adminService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        AdminRepository adminRepository = new AdminRepositoryImpl();
        adminService = new AdminServiceImpl(adminRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        try {
            if (action == null || action.isEmpty()) {
                req.getRequestDispatcher("/WEB-INF/view/admin/admin-dashboard.jsp").forward(req, resp);
                return;
            }

            switch (action) {
                // Manage Patients
                case "addPatient":
                    req.getRequestDispatcher("/WEB-INF/view/patient/add.jsp").forward(req, resp);
                    break;
                case "updatePatient":
                    req.getRequestDispatcher("/WEB-INF/view/patient/update.jsp").forward(req, resp);
                    break;
                case "deletePatient":
                    resp.sendRedirect("admin/dashboard?action=listPatients");
                    break;
                case "findPatient":
                    req.getRequestDispatcher("/WEB-INF/view/patient/details.jsp").forward(req, resp);
                    break;
                case "listPatients":
                    req.getRequestDispatcher("/WEB-INF/view/patient/list.jsp").forward(req, resp);
                    break;

                // Manage Departments
                case "createDepartment":
                    req.getRequestDispatcher("/WEB-INF/view/department/add.jsp").forward(req, resp);
                    break;
                case "updateDepartment":
                    req.getRequestDispatcher("/WEB-INF/view/department/update.jsp").forward(req, resp);
                    break;
                case "deleteDepartment":
                    resp.sendRedirect("admin/dashboard?action=listDepartments");
                    break;

                // Manage Doctors
                case "createDoctor":
                    req.getRequestDispatcher("/WEB-INF/view/doctor/add.jsp").forward(req, resp);
                    break;
                case "updateDoctor":
                    req.getRequestDispatcher("/WEB-INF/view/doctor/update.jsp").forward(req, resp);
                    break;
                case "deleteDoctor":
//                    req.getRequestDispatcher("/WEB-INF/view/doctor/add.jsp").forward(req, resp);
                case "listDoctors":
                    req.getRequestDispatcher("/WEB-INF/view/doctor/list.jsp").forward(req, resp);
                    break;

                // Manage Rooms
                case "createRoom":
                case "updateRoom":
                case "deleteRoom":
                case "listRooms":
                    req.getRequestDispatcher("/WEB-INF/view/admin/salle-menagment.jsp").forward(req, resp);
                    break;

                // Supervise Consultations
                case "superviseConsultations":
                    req.getRequestDispatcher("/WEB-INF/view/admin/consultation-supervision.jsp").forward(req, resp);
                    break;

                default:
                    req.getRequestDispatcher("/WEB-INF/view/admin/admin-dashboard.jsp").forward(req, resp);
                    break;
            }

        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/view/admin/admin-dashboard.jsp").forward(req, resp);
        }
    }
}
