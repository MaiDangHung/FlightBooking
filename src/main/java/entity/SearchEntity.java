
package entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SearchEntity {
    @Id
    private Date dateGoes;
    private String timeGoes;
    private String froms;
    private String tos;
    private int flightID;
    private double price;
    private String intendTime;

    public SearchEntity() {
    }

    public SearchEntity(Date dateGoes, String timeGoes, String froms, String tos, int flightID, double price, String intendTime) {
        this.dateGoes = dateGoes;
        this.timeGoes = timeGoes;
        this.froms = froms;
        this.tos = tos;
        this.flightID = flightID;
        this.price = price;
        this.intendTime = intendTime;
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

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double money) {
        this.price = money;
    }

    public String getIntendTime() {
        return intendTime;
    }

    public void setIntendTime(String intendTime) {
        this.intendTime = intendTime;
    }
    
    
    
}
