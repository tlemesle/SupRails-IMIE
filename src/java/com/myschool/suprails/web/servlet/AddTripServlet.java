package com.myschool.suprails.web.servlet;

import com.myschool.suprails.dao.TrainStationDao;
import com.myschool.suprails.entity.TrainStation;
import com.myschool.suprails.entity.Trip;
import com.myschool.suprails.service.TrainStationService;
import com.myschool.suprails.service.TripService;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
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
@WebServlet(name = "AddTripServlet", urlPatterns = {"/admin/trips/add"})
public class AddTripServlet extends HttpServlet {

    @EJB
    private TrainStationService trainStationService;
    
    @EJB
    private TripService tripService;
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TrainStation> trainStations = trainStationService.getAllTrainStations();
        req.setAttribute("stations", trainStations);
        req.getRequestDispatcher("/jsp/addTrip.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String departureParam = req.getParameter("departure");
        String arrivalParam = req.getParameter("arrival");
        String priceParam = req.getParameter("price");
        
        Long departureId = Long.valueOf(departureParam);
        Long arrivalId = Long.valueOf(arrivalParam);
        BigDecimal price = new BigDecimal(priceParam);
        
        TrainStation departureStation = trainStationService.findTrainStationById(departureId);
        TrainStation arrivalStation = trainStationService.findTrainStationById(arrivalId);
        
        Trip trip = new Trip(departureStation, arrivalStation, price);
        
        tripService.addTrip(trip);
        
        resp.sendRedirect(getServletContext().getContextPath() + "/trips");
    }
    
}
