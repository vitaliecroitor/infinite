package md.vcroitor.licenta.client.domain;

public class Shop {

    private String id;
    private int rating;
    private String name;
    private String image;
    private String category;
    private String nrOfPromotions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNrOfPromotions() {
        return nrOfPromotions;
    }

    public void setNrOfPromotions(String nrOfPromotions) {
        this.nrOfPromotions = nrOfPromotions;
    }
}