/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.RouteEntity;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends CrudRepository<RouteEntity, Integer>{
    @Query(value ="select * from RouteFlight,airportStation where froms =? and RouteFlight.froms=airportStation.airportID",nativeQuery = true)
    List<RouteEntity> getRouteByFroms(String froms);
    @Query(value ="select * from RouteFlight,Flight where flightID=? and RouteFlight.routeID=Flight.routeID",nativeQuery = true)
    RouteEntity getRouteByID(int flightID);
}
