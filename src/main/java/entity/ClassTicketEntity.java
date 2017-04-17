
package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ClassTicket")
public class ClassTicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classTicketID;
    private String classTicketName;
    private int percents;
    
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private TicketEntity ticketEntity;

    public ClassTicketEntity() {
    }

    public ClassTicketEntity(String classTicketName, int percents, TicketEntity ticketEntity) {
        this.classTicketName = classTicketName;
        this.percents = percents;
        this.ticketEntity = ticketEntity;
    }

    public int getClassTicketID() {
        return classTicketID;
    }

    public void setClassTicketID(int classTicketID) {
        this.classTicketID = classTicketID;
    }

    public String getClassTicketName() {
        return classTicketName;
    }

    public void setClassTicketName(String classTicketName) {
        this.classTicketName = classTicketName;
    }

    public int getPercents() {
        return percents;
    }

    public void setPercents(int percents) {
        this.percents = percents;
    }

    public TicketEntity getTicketEntity() {
        return ticketEntity;
    }

    public void setTicketEntity(TicketEntity ticketEntity) {
        this.ticketEntity = ticketEntity;
    }
    
    
    
}
