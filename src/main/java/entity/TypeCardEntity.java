
package entity;

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

@Entity
@Table(name="TypeCard")
public class TypeCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardID;
    private String cardName;
    
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private TypeCardEntity typeCardEntity;

    public TypeCardEntity() {
    }

    public TypeCardEntity(String cardName, TypeCardEntity typeCardEntity) {
        this.cardName = cardName;
        this.typeCardEntity = typeCardEntity;
    }

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public TypeCardEntity getTypeCardEntity() {
        return typeCardEntity;
    }

    public void setTypeCardEntity(TypeCardEntity typeCardEntity) {
        this.typeCardEntity = typeCardEntity;
    }
    
    
}
