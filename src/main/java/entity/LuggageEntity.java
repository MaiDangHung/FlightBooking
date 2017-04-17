
package entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Luggage")
public class LuggageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lugID;
    private String lugName;
    private double price;
    
    
    @OneToOne(mappedBy = "luggageEntity")
    private TicketEntity ticket;

    public LuggageEntity() {
    }

    public LuggageEntity(String lugName, double price, TicketEntity ticket) {
        this.lugName = lugName;
        this.price = price;
        this.ticket = ticket;
    }

    public int getLugID() {
        return lugID;
    }

    public void setLugID(int lugID) {
        this.lugID = lugID;
    }

    public String getLugName() {
        return lugName;
    }

    public void setLugName(String lugName) {
        this.lugName = lugName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TicketEntity getTicket() {
        return ticket;
    }

    public void setTicket(TicketEntity ticket) {
        this.ticket = ticket;
    }
    
    
}
