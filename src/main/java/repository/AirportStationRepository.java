/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.AirportStationEntity;
import entity.SearchEntity;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportStationRepository extends CrudRepository<AirportStationEntity, Integer>{
    @Query(value ="select airportName from AirportStation where airportID=?",nativeQuery = true)
    String getAirName(String ID);
}
