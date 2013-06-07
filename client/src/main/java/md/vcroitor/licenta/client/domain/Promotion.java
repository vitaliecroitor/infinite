package md.vcroitor.licenta.client.domain;

public class Promotion {
	
	private String id;
	private String title;
	private String description;
	private String oldPrice;
	private String newPrice;
    private String imageUrl;
	private int image;
    private String nrOfOrders;
    private String saveMoney;
    private String discount;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(String oldPrice) {
		this.oldPrice = oldPrice;
	}
	public String getNewPrice() {
		return newPrice;
	}
	public void setNewPrice(String newPrice) {
		this.newPrice = newPrice;
	}
	public int getImage() {
		return image;
	}
	public void setImage(int image) {
		this.image = image;
	}

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNrOfOrders() {
        return nrOfOrders;
    }

    public void setNrOfOrders(String nrOfOrders) {
        this.nrOfOrders = nrOfOrders;
    }

    public String getSaveMoney() {
        return saveMoney;
    }

    public void setSaveMoney(String saveMoney) {
        this.saveMoney = saveMoney;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}