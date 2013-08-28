package md.vcroitor.licenta.client;

import md.vcroitor.licenta.client.domain.Promotion;
import md.vcroitor.licenta.client.domain.Shop;

/**
 * User: vcroitor
 * Date: 6/10/13
 * Time: 8:30 AM
 */
public class DummyData {

    public enum IdEnum {
        Shop, Promotion
    }

    public enum ShopEnum {
        GLADIATOR, NEFERTITI, BLA
    }

    public enum PromotionEnum {

    }

    public static Shop getShop(ShopEnum shopEnum) {
        Shop shop = new Shop();

        switch (shopEnum) {
            case GLADIATOR: {
                shop.setName("");
            }
        }

        return shop;
    }

    public static Promotion getPromotion () {
        Promotion promotion = new Promotion();


        return promotion;
    }

}
