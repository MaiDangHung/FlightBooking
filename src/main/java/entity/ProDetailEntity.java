
package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ProDetail")
public class ProDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int proDetailID;
    
    @ManyToOne
    @JoinColumn(name="flightID")
    private AirCraftEntity proDetail;
    
    @ManyToOne
    @JoinColumn(name="proID")
    private PromotionEntity proDetails;

    public ProDetailEntity() {
    }

    public ProDetailEntity(AirCraftEntity proDetail, PromotionEntity proDetails) {
        this.proDetail = proDetail;
        this.proDetails = proDetails;
    }

    public int getProDetailID() {
        return proDetailID;
    }

    public void setProDetailID(int proDetailID) {
        this.proDetailID = proDetailID;
    }

    public AirCraftEntity getProDetail() {
        return proDetail;
    }

    public void setProDetail(AirCraftEntity proDetail) {
        this.proDetail = proDetail;
    }

    public PromotionEntity getProDetails() {
        return proDetails;
    }

    public void setProDetails(PromotionEntity proDetails) {
        this.proDetails = proDetails;
    }
    
    
}
