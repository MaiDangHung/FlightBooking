
package entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CartEntity {
    @Id
    private int flightID;
    private String froms;
    private String tos;
    private Date dateGoes;
    private String timeGoes;
    private String seat;
    private double price;
    private String classTicket;
    private String typeTicket;
    private String cusName;
    private String cmnd;
    private String luggage;

    public CartEntity(int flightID, String froms, String tos, Date dateGoes, String timeGoes, String seat, double price, String classTicket, String typeTicket, String cusName, String cmnd, String luggage) {
        this.flightID = flightID;
        this.froms = froms;
        this.tos = tos;
        this.dateGoes = dateGoes;
        this.timeGoes = timeGoes;
        this.seat = seat;
        this.price = price;
        this.classTicket = classTicket;
        this.typeTicket = typeTicket;
        this.cusName = cusName;
        this.cmnd = cmnd;
        this.luggage = luggage;
    }

    public String getLuggage() {
        return luggage;
    }

    public void setLuggage(String luggage) {
        this.luggage = luggage;
    }

    public CartEntity() {
    }

    public CartEntity(int flightID, String froms, String tos, Date dateGoes, String timeGoes, String seat, double price, String classTicket, String typeTicket, String cusName, String cmnd) {
        this.flightID = flightID;
        this.froms = froms;
        this.tos = tos;
        this.dateGoes = dateGoes;
        this.timeGoes = timeGoes;
        this.seat = seat;
        this.price = price;
        this.classTicket = classTicket;
        this.typeTicket = typeTicket;
        this.cusName = cusName;
        this.cmnd = cmnd;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
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

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getClassTicket() {
        return classTicket;
    }

    public void setClassTicket(String classTicket) {
        this.classTicket = classTicket;
    }

    public String getTypeTicket() {
        return typeTicket;
    }

    public void setTypeTicket(String typeTicket) {
        this.typeTicket = typeTicket;
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
    
    
}
