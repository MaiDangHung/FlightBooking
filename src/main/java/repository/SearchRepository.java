/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.SearchEntity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends CrudRepository<SearchEntity, Integer>{
    @Query(value ="select Flight.dateGoes,RouteFlight.froms,RouteFlight.tos,Flight.flightID,Flight.price,Flight.timeGoes,RouteFlight.intendTime from Flight,RouteFlight where dateGoes >= ? and froms=? and tos=? and Flight.routeID=RouteFlight.routeID",nativeQuery = true)
    List<SearchEntity> getAllOneWay(String date,String froms, String tos);
    
    @Query(value ="select Flight.dateGoes,RouteFlight.froms,RouteFlight.tos,Flight.flightID,Flight.price,Flight.timeGoes,RouteFlight.intendTime from Flight,RouteFlight where dateGoes >= ? and froms=? and tos=? and Flight.routeID=RouteFlight.routeID",nativeQuery = true)
    List<SearchEntity> getAllTwoWay(String date,String froms, String tos);
}
