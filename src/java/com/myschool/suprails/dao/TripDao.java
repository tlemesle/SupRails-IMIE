package com.myschool.suprails.dao;

import com.myschool.suprails.entity.TrainStation;
import com.myschool.suprails.entity.Trip;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 *    
 */
@Local
public interface TripDao {
    
    Trip addTrip(Trip trip);
    
    List<Trip> getAllTrips();

    public Trip findTripById(Long tripId);

    public void removeTrip(Trip findTripById);
    
    public List<Trip> findTripByStation(Long departure, Long arrival, BigDecimal price);
}
