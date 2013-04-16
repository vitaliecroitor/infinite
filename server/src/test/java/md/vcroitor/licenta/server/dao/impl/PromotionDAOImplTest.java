package md.vcroitor.licenta.server.dao.impl;

import md.vcroitor.licenta.server.dao.AbstractDAOTest;
import md.vcroitor.licenta.server.dao.PromotionDAO;
import md.vcroitor.licenta.server.dao.ShopDAO;
import md.vcroitor.licenta.server.persistence.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static md.vcroitor.licenta.common.enums.PromotionStatus.AVAILABLE;
import static md.vcroitor.licenta.common.enums.ShopCategory.SPORT;
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

    @Before
    public void setUp() {
        mongoTemplate.dropCollection(PROMOTION_COLLECTION_NAME);
        mongoTemplate.dropCollection(SHOP_COLLECTION_NAME);
    }

    @After
    public void after() {
       // mongoTemplate.dropCollection(PROMOTION_COLLECTION_NAME);
       // mongoTemplate.dropCollection(SHOP_COLLECTION_NAME);
    }

    @Test
    public void testGetByShopId() throws Exception {

        Shop shop = getShop();
        shopDAO.create(shop);

        Promotion promotion = dummyPromotion(null, new Date(), new Date(), 123, 111, AVAILABLE, dummyPromotionInfo("Promotion description"), shop);
        promotionDAO.create(promotion);

        Set<Promotion> promotions = promotionDAO.getByShopId(shop.getId());

        assertThat(promotions.size(), equalTo(2));
        assertThat(promotions.iterator().next().getShop().getId(), equalTo(shop.getId()));
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
