package md.vcroitor.licenta.common.dto;

import md.vcroitor.licenta.common.enums.PromotionCategoryEnum;
import md.vcroitor.licenta.common.enums.PromotionStatusEnum;

import java.util.Date;

public class PromotionDTO {

    private String id;

    private Date createdDate;

    private Date expireDate;

    private int oldPrice;

    private int newPrice;

    private String title;

    private PromotionStatusEnum status;

    private PromotionCategoryEnum category;

    private String shopId;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }
}