/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "airportStation")
public class AirportStationEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airportID")
    private int airportID;
    
    @Column(name = "airportName")
    private String airportName;
    
    @OneToMany(mappedBy = "fromsStation")
    List<RouteEntity> listRoutefroms;
    
    @OneToMany(mappedBy = "tosStation")
    List<RouteEntity> listRoutetos;

    public AirportStationEntity() {
    }        

    public int getAirportID() {
        return airportID;
    }

    public void setAirportID(int airportID) {
        this.airportID = airportID;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public List<RouteEntity> getListRoutefroms() {
        return listRoutefroms;
    }

    public void setListRoutefroms(List<RouteEntity> listRoutefroms) {
        this.listRoutefroms = listRoutefroms;
    }
   
    public List<RouteEntity> getListRoutetos() {
        return listRoutetos;
    }

    public void setListRoutetos(List<RouteEntity> listRoutetos) {
        this.listRoutetos = listRoutetos;
    }

    @Override
    public String toString() {
        return "AirportName: "+airportName;
    }
   
    
}