
package entity;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="transactionLog")
public class TransactionLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int transactionID;
    private int creditCardID;
    private int bookingID;
    
    @ManyToOne
    @JoinColumn(name="creditCardID", insertable = false, updatable = false)
    private CreditCardEntity creditCard;
    
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private BookingEntity bookingEntity;
    
    private double amount;

    public BookingEntity getBookingEntity() {
        return bookingEntity;
    }

    public void setBookingEntity(BookingEntity bookingEntity) {
        this.bookingEntity = bookingEntity;
    }


    
        
    public TransactionLogEntity() {
    }

    public TransactionLogEntity(int cardID, Date paymentDate, double amount, String description) {
        this.creditCardID = cardID;
        this.amount = amount;
    }

    public TransactionLogEntity(CreditCardEntity creditCard, Date paymentDate, double amount, String description) {
        this.creditCard = creditCard;
        this.amount = amount;
    }

    public TransactionLogEntity(int transactionID, int creditCardID, int bookingID, double amount) {
        this.transactionID = transactionID;
        this.creditCardID = creditCardID;
        this.bookingID = bookingID;
        this.amount = amount;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getCreditCardID() {
        return creditCardID;
    }

    public void setCreditCardID(int creditCardID) {
        this.creditCardID = creditCardID;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public CreditCardEntity getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCardEntity creditCard) {
        this.creditCard = creditCard;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    
    
    
}
