
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
@Table(name="Aircraft")
public class AirCraftEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int airID;
    private String airName;
    private int numberSeats;
    private String picture;
    private String description;
    private int ecoNumberSeats;
    private int skybossNumberSeats;
    
    @OneToMany(mappedBy = "aircraft", fetch = FetchType.EAGER)
    private List<FlightEntity> flightEntityList;

    public AirCraftEntity() {
    }

    public AirCraftEntity(String airName, int numberSeats, String picture, String description, List<FlightEntity> flightEntityList) {
        this.airName = airName;
        this.numberSeats = numberSeats;
        this.picture = picture;
        this.description = description;
        this.flightEntityList = flightEntityList;
    }

    public AirCraftEntity(String airName, int numberSeats, String picture, String description, int ecoNumberSeats, int skybossNumberSeats) {
        this.airName = airName;
        this.numberSeats = numberSeats;
        this.picture = picture;
        this.description = description;
        this.ecoNumberSeats = ecoNumberSeats;
        this.skybossNumberSeats = skybossNumberSeats;
    }

    public int getAirID() {
        return airID;
    }

    public void setAirID(int airID) {
        this.airID = airID;
    }

    public String getAirName() {
        return airName;
    }

    public void setAirName(String airName) {
        this.airName = airName;
    }

    public int getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(int numberSeats) {
        this.numberSeats = numberSeats;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<FlightEntity> getFlightEntityList() {
        return flightEntityList;
    }

    public void setFlightEntityList(List<FlightEntity> flightEntityList) {
        this.flightEntityList = flightEntityList;
    }

    public int getEcoNumberSeats() {
        return ecoNumberSeats;
    }

    public void setEcoNumberSeats(int ecoNumberSeats) {
        this.ecoNumberSeats = ecoNumberSeats;
    }

    public int getSkybossNumberSeats() {
        return skybossNumberSeats;
    }

    public void setSkybossNumberSeats(int skybossNumberSeats) {
        this.skybossNumberSeats = skybossNumberSeats;
    }
    
    
}
