
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
    private int seatNumber;
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

    public TicketEntity(int seatNumber, String cusName, String cmnd, double priceTicket, BookingEntity booking, ClassTicketEntity classTicketEntity, LuggageEntity luggageEntity, FlightEntity flight, TypeTicketEntity typeTicket) {
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
    
    
}
