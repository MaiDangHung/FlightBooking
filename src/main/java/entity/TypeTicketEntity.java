
package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TypeTicket")
public class TypeTicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeID;
    private String typeName;
    private int percents;
    
    @OneToOne(mappedBy = "typeTicket")
    private TicketEntity ticketEntity;

    public TypeTicketEntity() {
    }

    public TypeTicketEntity(String typeName, int percents, TicketEntity ticketEntity) {
        this.typeName = typeName;
        this.percents = percents;
        this.ticketEntity = ticketEntity;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
