package md.vcroitor.licenta.server.persistence;

import md.vcroitor.licenta.common.enums.PromotionCategory;
import md.vcroitor.licenta.common.enums.PromotionStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

import static javax.persistence.EnumType.*;
import static md.vcroitor.licenta.server.persistence.Promotion.COLLECTION_NAME;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 9:40 AM
 */
@Document(collection = COLLECTION_NAME)
public class Promotion {

    public static final String COLLECTION_NAME = "promotions";

    @Id
    private String id;
    private Date createdDate;
    private Date expireDate;
    private double oldPrice;
    private double newPrice;
    @Enumerated(STRING)
    private PromotionStatus status;
    @Enumerated(STRING)
    private PromotionCategory category;
   // private Shop shop;
    //private PromotionInfo info;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public PromotionStatus getStatus() {
        return status;
    }

    public void setStatus(PromotionStatus status) {
        this.status = status;
    }

    public PromotionCategory getCategory() {
        return category;
    }

    public void setCategory(PromotionCategory category) {
        this.category = category;
    }
}