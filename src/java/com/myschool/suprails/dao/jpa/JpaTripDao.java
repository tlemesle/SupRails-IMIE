package com.myschool.suprails.dao.jpa;

import com.myschool.suprails.dao.TripDao;
import com.myschool.suprails.entity.TrainStation;
import com.myschool.suprails.entity.TrainStation_;
import com.myschool.suprails.entity.Trip;
import com.myschool.suprails.entity.Trip_;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 *    
 */
@Stateless
public class JpaTripDao implements TripDao {

    @PersistenceContext
    private EntityManager em;

    
    @Override
    public Trip addTrip(Trip trip) {
        em.persist(trip);
        return trip;
    }

    @Override
    public List<Trip> getAllTrips() {
        //return em.createQuery("SELECT t FROM Trip t").getResultList();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Trip> query = criteriaBuilder.createQuery(Trip.class);
        List<Trip> results = em.createQuery(query).getResultList();
        
        return results;
    }

    @Override
    public Trip findTripById(Long tripId) {
        return em.find(Trip.class, tripId);
    }

    @Override
    public void removeTrip(Trip trip) {
        em.remove(trip);
    }

    @Override
    public List<Trip> findTripByStation(Long departure, Long arrival, BigDecimal price) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Trip> query = criteriaBuilder.createQuery(Trip.class);
        
        Root<Trip> trip = query.from(Trip.class);
        
        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(criteriaBuilder.equal(trip.get(Trip_.departureStation).get(TrainStation_.id), departure));
        predicates.add(criteriaBuilder.equal(trip.get(Trip_.arrivalStation).get(TrainStation_.id), arrival));
        predicates.add(criteriaBuilder.le(trip.get(Trip_.price), price));
        query.where(predicates.toArray(new Predicate [predicates.size()]));
        
        List<Trip> results = em.createQuery(query).getResultList();
//query.where(criteriaBuilder.equal(trip.get("DEPARTURESTATION_ID"), departure.getId()));
        
        return results;
    }
    
    
}
