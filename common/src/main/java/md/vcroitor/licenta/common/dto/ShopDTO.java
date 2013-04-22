package md.vcroitor.licenta.common.dto;

import md.vcroitor.licenta.common.enums.ShopCategoryEnum;

/**
 * User: Vitalie Croitor
 * Date: 4/22/13
 * Time: 1:59 PM
 */
public class ShopDTO {

    private String id;

    private String name;

    private ShopInfoDTO info;

    private ShopCategoryEnum category;

    private int rating;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShopInfoDTO getInfo() {
        return info;
    }

    public void setInfo(ShopInfoDTO info) {
        this.info = info;
    }

    public ShopCategoryEnum getCategory() {
        return category;
    }

    public void setCategory(ShopCategoryEnum category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
