package com.myschool.suprails.service;

import com.myschool.suprails.dao.TripDao;
import com.myschool.suprails.entity.TrainStation;
import com.myschool.suprails.entity.Trip;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 *    
 */
@Stateless
public class TripService {
    
    @EJB
    private TripDao tripDao;
    
    
    public Trip addTrip(Trip trip) {
        return tripDao.addTrip(trip);
    }
    
    public List<Trip> getAllTrips() {
        return tripDao.getAllTrips();
    }

    public void removeTrip(Long tripId) {
        tripDao.removeTrip(findTripById(tripId));
    }
    
    public Trip findTripById(Long tripId) {
        return tripDao.findTripById(tripId);
    }

    public List<Trip> findTripByStation(Long departure, Long arrival, BigDecimal price){
        return tripDao.findTripByStation(departure, arrival,price);
    }
}
