package org.mustapha.digitalhospitaljee.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mustapha.digitalhospitaljee.Repository.DepartmentRepository;
import org.mustapha.digitalhospitaljee.Repository.DoctorRepository;
import org.mustapha.digitalhospitaljee.Repository.impl.DepartmentRepositoryImpl;
import org.mustapha.digitalhospitaljee.Repository.impl.DoctorRepositoryImpl;
import org.mustapha.digitalhospitaljee.model.Department;
import org.mustapha.digitalhospitaljee.model.Doctor;
import org.mustapha.digitalhospitaljee.model.Person;
import org.mustapha.digitalhospitaljee.service.DepartmentService;
import org.mustapha.digitalhospitaljee.service.DoctorService;
import org.mustapha.digitalhospitaljee.service.impl.DepartmentServiecImpl;
import org.mustapha.digitalhospitaljee.service.impl.DoctorServiceImpl;

import java.io.IOException;
import java.util.List;
@WebServlet("/department/*")

public class DepartmentController extends HttpServlet {

    private DepartmentService departmentService;
    private DoctorService doctorService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        DepartmentRepository depa = new DepartmentRepositoryImpl();
        departmentService = new DepartmentServiecImpl(depa);

        DoctorRepository docrepo = new DoctorRepositoryImpl();
        doctorService = new DoctorServiceImpl(docrepo);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");


        switch (action){
            case "add":
                req.getRequestDispatcher("/WEB-INF/view/department/add.jsp").forward(req, resp);
                break;
            case "list":
                List<Department> departmentlist = departmentService.departmentList();
                req.setAttribute("departments", departmentlist);
                req.getRequestDispatcher("/WEB-INF/view/department/list.jsp").forward(req, resp);
                break;
            case "delete":
                long iddepa= Long.parseLong(req.getParameter("id"));
                departmentService.delete(iddepa);
                resp.sendRedirect(req.getContextPath() + "/department?action=list");
                break;
            case "edit":
                long id= Long.parseLong(req.getParameter("id"));
                Department department = departmentService.findDepartment(id);
                req.setAttribute("department", department);
                req.getRequestDispatcher("/WEB-INF/view/department/update.jsp").forward(req, resp);
                break;
            case "myDepartment":
                try {
                    HttpSession session = req.getSession(false);


                    if (session == null || session.getAttribute("currentUserId") == null) {
                        resp.sendRedirect(req.getContextPath() + "/login.jsp");
                        return;
                    }


                    Long currentUserId = (Long) session.getAttribute("currentUserId");


                    Doctor currentUser = doctorService.findById(currentUserId);


                    String doctorDepartment = currentUser.getDepartment().getName();


                    req.setAttribute("myDepartment", doctorDepartment);


                    req.getRequestDispatcher("/WEB-INF/view/department/myDepartment.jsp").forward(req, resp);

                } catch (Exception e) {
                    throw new ServletException("Failed to load doctor's department: " + e.getMessage(), e);
                }
                break;


            default:
                req.getRequestDispatcher("/WEB-INF/view/assets/dashboards/admin-dashboard.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "addDepartment":
                String name = req.getParameter("departmentname");
                Department department = new Department();
                department.setName(name);
                departmentService.create(department);
                req.setAttribute("message", "Department created successfully!");
                req.getRequestDispatcher("/WEB-INF/view/assets/success/successMessage.jsp").forward(req, resp);
                break;

            case "delete":
                Long id = Long.parseLong(req.getParameter("id"));
                departmentService.delete(id);
                resp.sendRedirect(req.getContextPath() + "/department?action=list");
                break;
            case "update":
                String departmentName = req.getParameter("departmentname");
                Long departmentId = Long.parseLong(req.getParameter("id"));
                Department department1 = new Department();
                department1.setName(departmentName);
                department1.setId(departmentId);
                departmentService.update(department1);
                req.setAttribute("message", "Department updated successfully!");
                req.getRequestDispatcher("/WEB-INF/view/assets/success/successMessage.jsp").forward(req, resp);
                break;
            default:
                req.getRequestDispatcher("/WEB-INF/view/assets/dashboards/admin-dashboard.jsp").forward(req, resp);
        }
    }
}
