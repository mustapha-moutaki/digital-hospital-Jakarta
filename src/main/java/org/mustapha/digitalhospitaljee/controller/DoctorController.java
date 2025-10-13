package org.mustapha.digitalhospitaljee.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mustapha.digitalhospitaljee.Exceptions.BusinessException;
import org.mustapha.digitalhospitaljee.Repository.AdminRepository;
import org.mustapha.digitalhospitaljee.Repository.DepartmentRepository;
import org.mustapha.digitalhospitaljee.Repository.DoctorRepository;
import org.mustapha.digitalhospitaljee.Repository.impl.AdminRepositoryImpl;
import org.mustapha.digitalhospitaljee.Repository.impl.DepartmentRepositoryImpl;
import org.mustapha.digitalhospitaljee.Repository.impl.DoctorRepositoryImpl;
import org.mustapha.digitalhospitaljee.model.Department;
import org.mustapha.digitalhospitaljee.model.Doctor;
import org.mustapha.digitalhospitaljee.service.DepartmentService;
import org.mustapha.digitalhospitaljee.service.DoctorService;
import org.mustapha.digitalhospitaljee.service.impl.DepartmentServiecImpl;
import org.mustapha.digitalhospitaljee.service.impl.DoctorServiceImpl;

import java.io.IOException;
import java.util.List;

import static java.lang.Long.parseLong;

@WebServlet("/doctor/*")
public class DoctorController extends HttpServlet {

    private DoctorService doctorService;
    private DepartmentService departmentService;
    @Override
    public void init() throws ServletException {
        DoctorRepository doctorRepo = new DoctorRepositoryImpl();
        doctorService = new DoctorServiceImpl(doctorRepo);

        DepartmentRepository depRepo = new DepartmentRepositoryImpl();
        departmentService = new DepartmentServiecImpl(depRepo);

    }

    // display the form
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null || action.isEmpty()) {
            req.getRequestDispatcher("/WEB-INF/view/assets/dashboards/doctor-dashboard.jsp").forward(req, resp);
            return;
        }

        switch (action) {
            case "list":
                List<Doctor> doctorList = doctorService.getAllDoctors();
                req.setAttribute("doctors", doctorList);

                req.getRequestDispatcher("/WEB-INF/view/doctor/list.jsp").forward(req, resp);
                break;
            case "add":
                List<Department> departments = departmentService.departmentList();
                req.setAttribute("departments", departments);
                req.getRequestDispatcher("/WEB-INF/view/doctor/add.jsp").forward(req, resp);
                break;

            case "delete":
                String idParam = req.getParameter("id");
                if (idParam != null && !idParam.isEmpty()) {
                    Long id = Long.parseLong(idParam);
                    doctorService.deleteDoctor(id);
                    resp.sendRedirect(req.getContextPath() + "/doctor/dashboard?action=list");
                } else {
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing doctor ID");
                }
                break;
            case "edit":
                String idParam1 = req.getParameter("id");
                if (idParam1 != null && !idParam1.isEmpty()) {
                    Long id = parseLong(idParam1);
                    List<Department>departmentList = departmentService.departmentList();
                    Doctor doctor = doctorService.findById(id);
                    req.setAttribute("doctorInfo", doctor);
                    req.setAttribute("departments", departmentList);

                    req.getRequestDispatcher("/WEB-INF/view/doctor/update.jsp").forward(req, resp);
                    break;
                }else{
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing doctor ID");
                }
                break;



            default:
                    req.getRequestDispatcher("/WEB-INF/view/assets/dashboards/doctor-dashboard.jsp").forward(req, resp);
        }
    }

    // send the data
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null || action.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing action parameter");
            return;
        }

        switch (action) {
            case "addDoctor": {
                String firstname = req.getParameter("firstName");
                String lastname = req.getParameter("lastName");
                String email = req.getParameter("email");
                String password = req.getParameter("password");
                String departmentIdParam = req.getParameter("department");
                String specialist = req.getParameter("specialization");

                Doctor doctor = new Doctor();
                doctor.setFirstName(firstname);
                doctor.setLastname(lastname);
                doctor.setEmail(email);
                doctor.setPassword(password);
                doctor.setSpecialist(specialist);

                if (departmentIdParam != null && !departmentIdParam.isEmpty()) {
                    Long departmentId = parseLong(departmentIdParam);
                    Department depa = new Department();
                    depa.setId(departmentId);
                    doctor.setDepartment(depa);
                }

                doctorService.createDoctor(doctor);
                resp.sendRedirect(req.getContextPath() + "/doctor/dashboard?action=list");
                break;
            }

            case "updateDoctor": {
                Long doctorId = parseLong(req.getParameter("id"));
                String firstname = req.getParameter("firstName");
                String lastname = req.getParameter("lastName");
                String email = req.getParameter("email");
                String password = req.getParameter("password");
                String specialist = req.getParameter("specialization");
                Long departmentId = parseLong(req.getParameter("department"));

                Doctor doctor = new Doctor();
                doctor.setId(doctorId); // imprtant : we tell jpa that we are updating not creating
                doctor.setFirstName(firstname);
                doctor.setLastname(lastname);
                doctor.setEmail(email);
                doctor.setPassword(password);
                doctor.setSpecialist(specialist);

                Department dp = new Department();
                dp.setId(departmentId);
                doctor.setDepartment(dp);

                doctorService.updateDoctor(doctor);
                resp.sendRedirect(req.getContextPath() + "/doctor/dashboard?action=list");
                break;
            }

            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Unknown action: " + action);
        }
    }

//        / Doctor
//        Doctor doctor = new Doctor();
//        doctor.setName(name);
//        doctor.setAge(age);
//
//        try {
//            doctorService.createDoctor(doctor); //
//            req.setAttribute("message", "Doctor created successfully!");
//            req.getRequestDispatcher("/WEB-INF/view/success.jsp").forward(req, resp);
//        } catch (BusinessException e) {
//            req.setAttribute("error", e.getMessage());
//            req.getRequestDispatcher("/WEB-INF/view/doctor.jsp").forward(req, resp);
//        } catch (Exception e) {
//            req.setAttribute("error", "Unexpected error: " + e.getMessage());
//            req.getRequestDispatcher("/WEB-INF/view/doctor.jsp").forward(req, resp);
//        }
//    }

    @Override
    public void destroy() {

    }
}
