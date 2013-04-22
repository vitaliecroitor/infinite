package md.vcroitor.licenta.server.persistence;

import md.vcroitor.licenta.common.enums.ShopCategoryEnum;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Enumerated;

import static javax.persistence.EnumType.STRING;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 9:43 AM
 */

@Document(collection = Shop.SHOP_COLLECTION_NAME)
public class Shop {

    public static final String SHOP_COLLECTION_NAME = "shops";

    @Id
    private String id;

    private String name;

    private ShopInfo info;

    @Enumerated(STRING)
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

    public ShopInfo getInfo() {
        return info;
    }

    public void setInfo(ShopInfo info) {
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

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}