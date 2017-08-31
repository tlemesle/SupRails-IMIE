package com.myschool.suprails.service;

import com.myschool.suprails.dao.TrainStationDao;
import com.myschool.suprails.entity.TrainStation;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 *    
 */
@Stateless
public class TrainStationService {

    @EJB
    private TrainStationDao trainStationDao;
    
    
    public void addTrainStation(TrainStation station) {
        trainStationDao.addTrainStation(station);
    }

    public List<TrainStation> getAllTrainStations() {
        return trainStationDao.getAllTrainStations();
    }

    public TrainStation findTrainStationById(Long departureId) {
        return trainStationDao.findTrainStationById(departureId);
    }
    
}
