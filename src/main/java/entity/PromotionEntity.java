
package entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Promotion")
public class PromotionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int proID;
    private String proName;
    private int discount;
    private Date dateStart;
    private Date dateEnd;
    
    @OneToMany(mappedBy = "proDetails", fetch = FetchType.EAGER)
    private List<ProDetailEntity> ProDetailEntityList;

    public PromotionEntity() {
    }

    public PromotionEntity(String proName, int discount, Date dateStart, Date dateEnd, List<ProDetailEntity> ProDetailEntityList) {
        this.proName = proName;
        this.discount = discount;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.ProDetailEntityList = ProDetailEntityList;
    }

    public int getProID() {
        return proID;
    }

    public void setProID(int proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public List<ProDetailEntity> getProDetailEntityList() {
        return ProDetailEntityList;
    }

    public void setProDetailEntityList(List<ProDetailEntity> ProDetailEntityList) {
        this.ProDetailEntityList = ProDetailEntityList;
    }
    
    
}
