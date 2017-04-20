
package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Ticket")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketID;
    private String seatNumber;
    private String cusName;
    private String cmnd;
    private double priceTicket;
    
    @ManyToOne
    @JoinColumn(name="ticketID", insertable = false, updatable = false)
    private BookingEntity booking;
    
    @OneToOne(mappedBy = "ticketEntity")
    private ClassTicketEntity classTicketEntity;
    
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private LuggageEntity luggageEntity;
    
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private FlightEntity flight;
    
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private TypeTicketEntity typeTicket;

    public TicketEntity() {
    }

    public TicketEntity(String seatNumber, String cusName, String cmnd, double priceTicket, BookingEntity booking, ClassTicketEntity classTicketEntity, LuggageEntity luggageEntity, FlightEntity flight, TypeTicketEntity typeTicket) {
        this.seatNumber = seatNumber;
        this.cusName = cusName;
        this.cmnd = cmnd;
        this.priceTicket = priceTicket;
        this.booking = booking;
        this.classTicketEntity = classTicketEntity;
        this.luggageEntity = luggageEntity;
        this.flight = flight;
        this.typeTicket = typeTicket;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public double getPriceTicket() {
        return priceTicket;
    }

    public void setPriceTicket(double priceTicket) {
        this.priceTicket = priceTicket;
    }

    public BookingEntity getBooking() {
        return booking;
    }

    public void setBooking(BookingEntity booking) {
        this.booking = booking;
    }

    public ClassTicketEntity getClassTicketEntity() {
        return classTicketEntity;
    }

    public void setClassTicketEntity(ClassTicketEntity classTicketEntity) {
        this.classTicketEntity = classTicketEntity;
    }

    public LuggageEntity getLuggageEntity() {
        return luggageEntity;
    }

    public void setLuggageEntity(LuggageEntity luggageEntity) {
        this.luggageEntity = luggageEntity;
    }

    public FlightEntity getFlight() {
        return flight;
    }

    public void setFlight(FlightEntity flight) {
        this.flight = flight;
    }

    public TypeTicketEntity getTypeTicket() {
        return typeTicket;
    }

    public void setTypeTicket(TypeTicketEntity typeTicket) {
        this.typeTicket = typeTicket;
    }
    
    
}
