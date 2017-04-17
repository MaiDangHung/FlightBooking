
package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="CardDetail")
public class CardDetailEntity {
    @Id
    private String cardName;
    private String cardNumber;
    private String cardDate;
    
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private BookingEntity bookingEntity;
    
    @OneToOne(mappedBy = "typeCardEntity")
    private TypeCardEntity typeCardEntity;

    public CardDetailEntity() {
    }

    public CardDetailEntity(String cardName, String cardNumber, String cardDate, BookingEntity bookingEntity, TypeCardEntity typeCardEntity) {
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.cardDate = cardDate;
        this.bookingEntity = bookingEntity;
        this.typeCardEntity = typeCardEntity;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardDate() {
        return cardDate;
    }

    public void setCardDate(String cardDate) {
        this.cardDate = cardDate;
    }

    public BookingEntity getBookingEntity() {
        return bookingEntity;
    }

    public void setBookingEntity(BookingEntity bookingEntity) {
        this.bookingEntity = bookingEntity;
    }

    public TypeCardEntity getTypeCardEntity() {
        return typeCardEntity;
    }

    public void setTypeCardEntity(TypeCardEntity typeCardEntity) {
        this.typeCardEntity = typeCardEntity;
    }
    
    
}
