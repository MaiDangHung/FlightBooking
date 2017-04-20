/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.AirCraftEntity;
import entity.SearchEntity;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirCraftRepository extends CrudRepository<AirCraftEntity, Integer>{
    @Query(value ="select distinct Aircraft.* from Aircraft,Flight where Aircraft.airID=Flight.airID and flightID=?",nativeQuery = true)
    AirCraftEntity getAirByFlightID(int flightID);
}
