package com.myschool.suprails.dao.jpa;

import com.myschool.suprails.dao.TrainStationDao;
import com.myschool.suprails.entity.TrainStation;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 *    
 */
@Stateless
public class JpaTrainStationDao implements TrainStationDao {

    @PersistenceContext
    private EntityManager em;
    
    
    @Override
    public TrainStation addTrainStation(TrainStation station) {
        em.persist(station);
        return station;
    }

    @Override
    public List<TrainStation> getAllTrainStations() {
        //return em.createQuery("SELECT ts FROM TrainStation ts").getResultList();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<TrainStation> query = criteriaBuilder.createQuery(TrainStation.class);
        List<TrainStation> results = em.createQuery(query).getResultList();
        
        return results;
    }

    @Override
    public TrainStation findTrainStationById(Long departureId) {
        return em.find(TrainStation.class, departureId);
    }
    
}
