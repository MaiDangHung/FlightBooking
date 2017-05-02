
package entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Booking")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int bookingID;
    private Date dateBook;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String customerEmail;
    private double totalAmount;
    
    @OneToMany(mappedBy = "booking", fetch = FetchType.EAGER)
    private List<TicketEntity> ticketEntityList;
    
    @OneToOne(mappedBy = "bookingEntity")
    private TransactionLogEntity transactionLog;

    public BookingEntity() {
    }

    public BookingEntity(Date dateBook, String customerName, String customerAddress, String customerPhone, String customerEmail, double totalAmount, List<TicketEntity> ticketEntityList, TransactionLogEntity transactionLog) {
        this.dateBook = dateBook;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.totalAmount = totalAmount;
        this.ticketEntityList = ticketEntityList;
        this.transactionLog = transactionLog;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public Date getDateBook() {
        return dateBook;
    }

    public void setDateBook(Date dateBook) {
        this.dateBook = dateBook;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<TicketEntity> getTicketEntityList() {
        return ticketEntityList;
    }

    public void setTicketEntityList(List<TicketEntity> ticketEntityList) {
        this.ticketEntityList = ticketEntityList;
    }

    public TransactionLogEntity getTransactionLog() {
        return transactionLog;
    }

    public void setTransactionLog(TransactionLogEntity transactionLog) {
        this.transactionLog = transactionLog;
    }

    
    
    
}
