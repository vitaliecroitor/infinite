package md.vcroitor.licenta.server.dao.impl;

import md.vcroitor.licenta.common.enums.ShopCategory;
import md.vcroitor.licenta.server.dao.AbstractDAOTest;
import md.vcroitor.licenta.server.dao.ShopDAO;
import md.vcroitor.licenta.server.persistence.Address;
import md.vcroitor.licenta.server.persistence.Contact;
import md.vcroitor.licenta.server.persistence.Shop;
import md.vcroitor.licenta.server.persistence.ShopInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

import static md.vcroitor.licenta.server.DummyObjects.*;
import static md.vcroitor.licenta.server.persistence.Shop.SHOP_COLLECTION_NAME;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * User: Vitalie Croitor
 * Date: 4/17/13
 * Time: 11:39 AM
 */
public class ShopDAOImplTest extends AbstractDAOTest {

    @Resource(name = "mongoTemplate")
    private MongoTemplate mongoTemplate;

    @Resource(name = "shopDAO")
    private ShopDAO shopDAO;

    @Before
    public void setUp() {
        mongoTemplate.dropCollection(SHOP_COLLECTION_NAME);
        shopDAO.create(getShop("Nokia", ShopCategory.HOME));
        shopDAO.create(getShop("Samsung", ShopCategory.FASHION));
    }

    @After
    public void after() {
        mongoTemplate.dropCollection(SHOP_COLLECTION_NAME);
    }

    @Test
    public void testGetPage() throws Exception {
        Set<Shop> shops = shopDAO.getPage(1, 1);
        assertThat(shops.size(), equalTo(1));
    }

    @Test
    public void testGetAll() throws Exception {
        Set<Shop> shops = shopDAO.getAll();
        assertThat(shops.size(), equalTo(2));
    }

    public Shop getShop(String name, ShopCategory category) {
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

        return dummyShop(null, name, shopInfo, category, 4);
    }
}
