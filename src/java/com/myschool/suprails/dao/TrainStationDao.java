package com.myschool.suprails.dao;

import com.myschool.suprails.entity.TrainStation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 *    
 */
@Local
public interface TrainStationDao {
    
    TrainStation addTrainStation(TrainStation station);

    List<TrainStation> getAllTrainStations();

    TrainStation findTrainStationById(Long departureId);
    
}
