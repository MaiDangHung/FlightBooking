
package entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="RouteFlight")
public class RouteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int routeID;
    private String froms;
    private String tos;
    private String distance;
    private String intendTime;
    
    @OneToMany(mappedBy = "routeEntity", fetch = FetchType.EAGER)
    private List<FlightEntity> flightEntityList;

    public RouteEntity(int routeID, String froms, String tos, String distance, String intendTime, List<FlightEntity> flightEntityList) {
        this.routeID = routeID;
        this.froms = froms;
        this.tos = tos;
        this.distance = distance;
        this.intendTime = intendTime;
        this.flightEntityList = flightEntityList;
    }

    public RouteEntity() {
    }

    public int getRouteID() {
        return routeID;
    }

    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }

    public String getFroms() {
        return froms;
    }

    public void setFroms(String froms) {
        this.froms = froms;
    }

    public String getTos() {
        return tos;
    }

    public void setTos(String tos) {
        this.tos = tos;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getIntendTime() {
        return intendTime;
    }

    public void setIntendTime(String intendTime) {
        this.intendTime = intendTime;
    }

    public List<FlightEntity> getFlightEntityList() {
        return flightEntityList;
    }

    public void setFlightEntityList(List<FlightEntity> flightEntityList) {
        this.flightEntityList = flightEntityList;
    }
    
    
    
}
