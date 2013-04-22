package md.vcroitor.licenta.server.persistence;

import md.vcroitor.licenta.common.enums.PromotionCategoryEnum;
import md.vcroitor.licenta.common.enums.PromotionStatusEnum;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Enumerated;
import java.util.Date;

import static javax.persistence.EnumType.STRING;
import static md.vcroitor.licenta.server.persistence.Promotion.PROMOTION_COLLECTION_NAME;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 9:40 AM
 */
@Document(collection = PROMOTION_COLLECTION_NAME)
public class Promotion {

    public static final String PROMOTION_COLLECTION_NAME = "promotions";

    @Id
    private String id;

    private String title;

    private Date createdDate;

    private Date expireDate;

    private int oldPrice;

    private int newPrice;

    @Enumerated(STRING)
    private PromotionStatusEnum status;

    @Enumerated(STRING)
    private PromotionCategoryEnum category;

    @DBRef
    private Shop shop;

    private PromotionInfo info;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(int oldPrice) {
        this.oldPrice = oldPrice;
    }

    public int getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(int newPrice) {
        this.newPrice = newPrice;
    }

    public PromotionStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PromotionStatusEnum status) {
        this.status = status;
    }

    public PromotionCategoryEnum getCategory() {
        return category;
    }

    public void setCategory(PromotionCategoryEnum category) {
        this.category = category;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public PromotionInfo getInfo() {
        return info;
    }

    public void setInfo(PromotionInfo info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}