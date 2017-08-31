package com.myschool.suprails.web.servlet;

import com.myschool.suprails.entity.TrainStation;
import com.myschool.suprails.entity.Trip;
import com.myschool.suprails.service.TrainStationService;
import com.myschool.suprails.service.TripService;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 *    
 */
@WebServlet(urlPatterns="/trips")
public class ListTripsServlet extends HttpServlet {

    @EJB
    private TripService tripService;
    
    @EJB
    private TrainStationService trainStationService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Trip> trips = tripService.getAllTrips();
        req.setAttribute("trips", trips);
        List<TrainStation> trainStations = trainStationService.getAllTrainStations();
        req.setAttribute("stations", trainStations);
        req.getRequestDispatcher("/jsp/listTrips.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String departureParam = req.getParameter("departure");
        String arrivalParam = req.getParameter("arrival");
        String priceParam = req.getParameter("price");
        
        Long departureId = Long.valueOf(departureParam);
        Long arrivalId = Long.valueOf(arrivalParam);
        BigDecimal price = new BigDecimal(priceParam);
                
        
        List<Trip> trips = tripService.findTripByStation(departureId, arrivalId,price);
        req.setAttribute("trips", trips);
        List<TrainStation> trainStations = trainStationService.getAllTrainStations();
        req.setAttribute("stations", trainStations);

        req.getRequestDispatcher("/jsp/listTrips.jsp").forward(req, resp);
        //resp.sendRedirect(getServletContext().getContextPath() + "/trips");
    }

}
