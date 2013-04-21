package md.vcroitor.licenta.server.dao.impl;

import md.vcroitor.licenta.server.dao.AbstractDAOTest;
import md.vcroitor.licenta.server.dao.PromotionDAO;
import md.vcroitor.licenta.server.dao.ShopDAO;
import md.vcroitor.licenta.server.persistence.*;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static md.vcroitor.licenta.common.enums.PromotionCategoryEnum.P_FASHION;
import static md.vcroitor.licenta.common.enums.PromotionCategoryEnum.P_FOOD;
import static md.vcroitor.licenta.common.enums.PromotionStatusEnum.AVAILABLE;
import static md.vcroitor.licenta.common.enums.PromotionStatusEnum.SUSPENDED;
import static md.vcroitor.licenta.common.enums.ShopCategoryEnum.SPORT;
import static md.vcroitor.licenta.server.DummyObjects.*;
import static md.vcroitor.licenta.server.persistence.Promotion.PROMOTION_COLLECTION_NAME;
import static md.vcroitor.licenta.server.persistence.Shop.SHOP_COLLECTION_NAME;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * User: Vitalie Croitor
 * Date: 4/15/13
 * Time: 4:47 PM
 */
public class PromotionDAOImplTest extends AbstractDAOTest {

    @Resource(name = "mongoTemplate")
    private MongoTemplate mongoTemplate;

    @Resource(name = "shopDAO")
    private ShopDAO shopDAO;

    @Resource(name = "promotionDAO")
    private PromotionDAO promotionDAO;

    private Shop shop;

    @Before
    public void setUp() {
        mongoTemplate.dropCollection(PROMOTION_COLLECTION_NAME);
        mongoTemplate.dropCollection(SHOP_COLLECTION_NAME);

        // create a shop to test with
        shop = getShop();
        shopDAO.create(shop);
    }

    @After
    public void after() {
        mongoTemplate.dropCollection(PROMOTION_COLLECTION_NAME);
        mongoTemplate.dropCollection(SHOP_COLLECTION_NAME);
    }

    @Test
    public void testGetByShopId() throws Exception {

        Promotion promotion = dummyPromotion(null, new Date(), new Date(), 123, 111, AVAILABLE, P_FOOD, dummyPromotionInfo("Promotion description"), shop);
        promotionDAO.create(promotion);

        Set<Promotion> promotions = promotionDAO.getByShopId(shop.getId());

        assertThat(promotions.size(), equalTo(1));
        assertThat(promotions.iterator().next().getShop().getId(), equalTo(shop.getId()));

        // remove all promotions from database
        mongoTemplate.dropCollection(PROMOTION_COLLECTION_NAME);
    }

    @Test
    public void testGetByStatus() {
        Promotion promotion = dummyPromotion(null, new Date(), new Date(), 123, 111, AVAILABLE, P_FOOD, dummyPromotionInfo("Promotion description"), shop);
        promotionDAO.create(promotion);

        Set<Promotion> promotions = promotionDAO.getByStatus(AVAILABLE);
        assertThat(promotions.size(), equalTo(1));
        assertThat(promotions.iterator().next().getStatus(), equalTo(AVAILABLE));

        // remove all promotions from database
        mongoTemplate.dropCollection(PROMOTION_COLLECTION_NAME);
    }

    @Test
    public void testGetByCategory() {
        Promotion promotion = dummyPromotion(null, new Date(), new Date(), 123, 111, AVAILABLE, P_FASHION, dummyPromotionInfo("Promotion description"), shop);
        Promotion p2 = dummyPromotion(null, new Date(), new Date(), 511, 431, SUSPENDED, P_FOOD, dummyPromotionInfo("Another"), shop);
        promotionDAO.create(promotion);
        promotionDAO.create(p2);

        Set<Promotion> promotions = promotionDAO.getByCategory(P_FASHION);
        assertThat(promotions.size(), equalTo(1));
        assertThat(promotions.iterator().next().getCategory(), equalTo(P_FASHION));

        // remove all promotions from database
        mongoTemplate.dropCollection(PROMOTION_COLLECTION_NAME);
    }

    @Test
    public void testGetByPeriod() {

        Promotion promotion = dummyPromotion(null, DateTime.now().toDate(), DateTime.now().toDate(), 123, 111, AVAILABLE, P_FASHION, dummyPromotionInfo("Promotion description"), shop);
        Promotion p2 = dummyPromotion(null, DateTime.now().minusDays(4).toDate(), DateTime.now().minusDays(4).toDate(), 511, 431, SUSPENDED, P_FOOD, dummyPromotionInfo("Another"), shop);
        promotionDAO.create(promotion);
        promotionDAO.create(p2);

        Set<Promotion> promotions = promotionDAO.getByPeriod(DateTime.now().minusDays(3).toDate(), DateTime.now().toDate());
        assertThat(promotions.size(), equalTo(1));

        // remove all promotions from database
        mongoTemplate.dropCollection(PROMOTION_COLLECTION_NAME);

    }


    public Shop getShop() {
        Set<String> phones = new HashSet<>();
        phones.add("+37369111222");
        phones.add("+37369111333");

        Set<String> emails = new HashSet<>();
        emails.add("abc@abc.com");
        emails.add("def@def.com");
        Contact contact = dummyContact(emails, phones, null);

        Set<Address> addresses = new HashSet<>();
        addresses.add(dummyAddress("country", "city", "street", 1234, contact));

        Address main = dummyAddress("mainCountry", "mainCity", "mainStreet", 1311, contact);
        ShopInfo shopInfo = dummyShopInfo(main, addresses, "http://abc.com", "mega description");

        return dummyShop(null, "Shop1", shopInfo, SPORT, 4);
    }
}
