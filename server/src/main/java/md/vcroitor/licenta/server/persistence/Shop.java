package md.vcroitor.licenta.server.persistence;

import md.vcroitor.licenta.common.enums.ShopCategory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 9:43 AM
 */

@Document(collection = Shop.COLLECTION_NAME)
public class Shop {

    public static final String COLLECTION_NAME = "shops";

    @Id
    private String id;

    private String name;

    private ShopInfo info;

    private ShopCategory category;

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

    public ShopCategory getCategory() {
        return category;
    }

    public void setCategory(ShopCategory category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}