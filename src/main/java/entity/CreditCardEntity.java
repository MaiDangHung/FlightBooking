
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
@Table(name="creditCard")
public class CreditCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int creditCardID;
    private int cardNumber;
    private int validateNumber;
    private int securityNumber;
    private double amount;

    @OneToMany(mappedBy = "creditCard",fetch = FetchType.EAGER)
    private List<TransactionLogEntity> transactionLog;
    
    public CreditCardEntity() {
    }

    public CreditCardEntity(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public CreditCardEntity(int cardNumber, int validateNumber, int securityNumber, double amount) {
        this.cardNumber = cardNumber;
        this.validateNumber = validateNumber;
        this.securityNumber = securityNumber;
        this.amount = amount;
    }

    public CreditCardEntity(int id, int cardNumber, int validateNumber, int securityNumber, double amount) {
        this.creditCardID= id;
        this.cardNumber = cardNumber;
        this.validateNumber = validateNumber;
        this.securityNumber = securityNumber;
        this.amount = amount;
    }

    public List<TransactionLogEntity> getTransactionLog() {
        return transactionLog;
    }

    public void setTransactionLog(List<TransactionLogEntity> transactionLog) {
        this.transactionLog = transactionLog;
    }

    public int getCreditCardId() {
        return creditCardID;
    }

    public void setCreditCardID(int id) {
        this.creditCardID = id;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getValidateNumber() {
        return validateNumber;
    }

    public void setValidateNumber(int validateNumber) {
        this.validateNumber = validateNumber;
    }

    public int getSecurityNumber() {
        return securityNumber;
    }

    public void setSecurityNumber(int securityNumber) {
        this.securityNumber = securityNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "id: "+creditCardID+"\n"+
               "Card Number: "+cardNumber+"\n"+
               "Amount: "+amount+"\n";
    }
    
    
}
