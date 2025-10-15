package org.mustapha.digitalhospitaljee.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mustapha.digitalhospitaljee.Repository.ConsultationRepository;
import org.mustapha.digitalhospitaljee.Repository.impl.ConsultationRepositoryImpl;
import org.mustapha.digitalhospitaljee.model.Consultation;
import org.mustapha.digitalhospitaljee.model.enums.ConsultationStatus;
import org.mustapha.digitalhospitaljee.service.ConsultationService;
import org.mustapha.digitalhospitaljee.service.impl.ConsultationServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/consultation/*")
public class ConsultationController extends HttpServlet {
    private ConsultationService consultationService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        ConsultationRepository consultationRepository = new ConsultationRepositoryImpl();
        consultationService = new ConsultationServiceImpl(consultationRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String action = req.getParameter("action");
       switch(action){
           case "allList":
               List<Consultation> consultationList = consultationService.consultationList();

               req.setAttribute("allConsultation", consultationList);
               req.setAttribute("status", ConsultationStatus.values());
               req.getRequestDispatcher("/WEB-INF/view/consultation/allList.jsp").forward(req, resp);
               break;
           case "delete":
               long idParam = Long.parseLong(req.getParameter("id"));
               consultationService.delete(idParam);
//               resp.getWriter().write("the consulataion removed successfully ");
                resp.sendRedirect(req.getContextPath()+"/consultation?action=allList");

               break;
           default:req.getRequestDispatcher("/WEB-INF/view/consultation/allList.jsp").forward(req, resp);

       }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "updateStatus":
                long id = Long.parseLong(req.getParameter("id"));
                String newConsultationSt = req.getParameter("consultationStatus");
                ConsultationStatus statusenum = ConsultationStatus.valueOf(newConsultationSt); // comverting form string to enum
                consultationService.changeStatus(id, statusenum);
                resp.sendRedirect(req.getContextPath()+"/consultation?action=allList");
                break;

            default: req.getRequestDispatcher("/WEB-INF/view/consultation/allList.jsp").forward(req, resp);
        }
    }
}
