
package entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Flight")
public class FlightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flightID;
    private Date dateGoes;
    private String timeGoes;
    private double price;
    
    @ManyToOne
    @JoinColumn(name="airID")
    private AirCraftEntity aircraft;
    
    @OneToMany(mappedBy = "proDetail", fetch = FetchType.EAGER)
    private List<ProDetailEntity> proDetailEntityList;
    
    @ManyToOne
    @JoinColumn(name="routeID")
    private RouteEntity routeEntity;
    
    @OneToOne(mappedBy = "flight")
    private TicketEntity ticketEntity;

    public FlightEntity() {
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public Date getDateGoes() {
        return dateGoes;
    }

    public void setDateGoes(Date dateGoes) {
        this.dateGoes = dateGoes;
    }

    public String getTimeGoes() {
        return timeGoes;
    }

    public void setTimeGoes(String timeGoes) {
        this.timeGoes = timeGoes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<ProDetailEntity> getProDetailEntityList() {
        return proDetailEntityList;
    }

    public void setProDetailEntityList(List<ProDetailEntity> proDetailEntityList) {
        this.proDetailEntityList = proDetailEntityList;
    }

    public RouteEntity getRouteEntity() {
        return routeEntity;
    }

    public void setRouteEntity(RouteEntity routeEntity) {
        this.routeEntity = routeEntity;
    }

    public TicketEntity getTicketEntity() {
        return ticketEntity;
    }

    public void setTicketEntity(TicketEntity ticketEntity) {
        this.ticketEntity = ticketEntity;
    }

    public AirCraftEntity getAircraft() {
        return aircraft;
    }

    public void setAircraft(AirCraftEntity aircraft) {
        this.aircraft = aircraft;
    }

    public FlightEntity(Date dateGoes, String timeGoes, double price, AirCraftEntity aircraft, List<ProDetailEntity> proDetailEntityList, RouteEntity routeEntity, TicketEntity ticketEntity) {
        this.dateGoes = dateGoes;
        this.timeGoes = timeGoes;
        this.price = price;
        this.aircraft = aircraft;
        this.proDetailEntityList = proDetailEntityList;
        this.routeEntity = routeEntity;
        this.ticketEntity = ticketEntity;
    }
    
    
}
