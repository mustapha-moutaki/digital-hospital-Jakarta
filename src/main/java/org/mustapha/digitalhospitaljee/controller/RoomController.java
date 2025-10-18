package org.mustapha.digitalhospitaljee.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mustapha.digitalhospitaljee.Exceptions.RoomException;
import org.mustapha.digitalhospitaljee.Repository.ConsultationRepository;
import org.mustapha.digitalhospitaljee.Repository.RoomRepository;
import org.mustapha.digitalhospitaljee.Repository.impl.ConsultationRepositoryImpl;
import org.mustapha.digitalhospitaljee.Repository.impl.DepartmentRepositoryImpl;
import org.mustapha.digitalhospitaljee.Repository.impl.RoomRepositoryImp;
import org.mustapha.digitalhospitaljee.model.Department;
import org.mustapha.digitalhospitaljee.model.Room;
//import org.mustapha.digitalhospitaljee.repository.impl.DepartmentRepositoryImpl;
import org.mustapha.digitalhospitaljee.service.ConsultationService;
import org.mustapha.digitalhospitaljee.service.DepartmentService;
import org.mustapha.digitalhospitaljee.service.RoomService;
//import org.mustapha.digitalhospitaljee.service.impl.DepartmentServiceImpl;
import org.mustapha.digitalhospitaljee.service.impl.ConsultationServiceImpl;
import org.mustapha.digitalhospitaljee.service.impl.DepartmentServiecImpl;
import org.mustapha.digitalhospitaljee.service.impl.RoomServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/rooms")
public class RoomController extends HttpServlet {

    // service to manage rooms
    private final RoomService roomService;
    // service to manage departments
    private final DepartmentService departmentService;
    private  final RoomRepository roomRepository;
    private final ConsultationRepository consultationRepository;

    public RoomController() {
        // init room service
        roomRepository =  new RoomRepositoryImp();
        consultationRepository = new ConsultationRepositoryImpl();
        ConsultationService  consultationService = new ConsultationServiceImpl(consultationRepository);
        this.roomService = new RoomServiceImpl(roomRepository, consultationService);
        // init department service with repository
        this.departmentService = new DepartmentServiecImpl(new DepartmentRepositoryImpl());
    }

    // GET request to display all rooms and departments
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // get all departments to show in dropdown
            List<Department> departments = departmentService.departmentList();
            req.setAttribute("departments", departments);

            // get all rooms to display in table
            req.setAttribute("rooms", roomService.roomList());

            // forward to JSP
            req.getRequestDispatcher("/WEB-INF/view/room/room-list.jsp").forward(req, resp);
        } catch (RoomException e) {
            resp.getWriter().println("Error: " + e.getMessage());
        }
    }

    // POST request to create, update, or delete room
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            if ("create".equals(action)) {
                // read form data
                String name = req.getParameter("name");
                int capacity = Integer.parseInt(req.getParameter("capacity"));
                Long departmentId = Long.parseLong(req.getParameter("departmentId")); // get selected department

                // get department object from service
                Department department = departmentService.findDepartment(departmentId);

                // create new room and set its properties
                Room room = new Room();
                room.setName(name);
                room.setCapacity(capacity);
                room.setDepartment(department); // link room with department

                // save to database
                roomService.create(room);
            } else if ("delete".equals(action)) {
                // delete room by id
                Long roomId = Long.parseLong(req.getParameter("id"));
                roomService.delete(roomId);
            } else if ("update".equals(action)) {
                // update existing room
                Long roomId = Long.parseLong(req.getParameter("id"));
                Room existing = roomService.getRoomById(roomId);
                existing.setName(req.getParameter("name"));
                existing.setCapacity(Integer.parseInt(req.getParameter("capacity")));
                Long departmentId = Long.parseLong(req.getParameter("departmentId"));
                existing.setDepartment(departmentService.findDepartment(departmentId));

                roomService.update(existing);
            }

            // redirect to refresh the page
            resp.sendRedirect(req.getContextPath() + "/rooms");
        } catch (Exception e) {
            resp.getWriter().println("Error: " + e.getMessage());
        }
    }
}
