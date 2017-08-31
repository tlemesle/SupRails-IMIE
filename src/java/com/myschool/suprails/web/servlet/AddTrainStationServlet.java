package com.myschool.suprails.web.servlet;

import com.myschool.suprails.entity.TrainStation;
import com.myschool.suprails.service.TrainStationService;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 *    
 */
@WebServlet(name = "AddTrainStationServlet", urlPatterns = {"/admin/train-stations/add"})
public class AddTrainStationServlet extends HttpServlet {

    @EJB
    private TrainStationService trainStationService;
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/addTrainStation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TrainStation trainStation = new TrainStation();
        trainStation.setName(req.getParameter("name"));
        trainStation.setAddress(req.getParameter("address"));
        trainStation.setCity(req.getParameter("city"));
        
        trainStationService.addTrainStation(trainStation);
        
        resp.sendRedirect(req.getContextPath() + "/train-stations");
    }
    
}
