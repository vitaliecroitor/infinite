package md.vcroitor.licenta.server.facade.impl;

import md.vcroitor.licenta.common.dto.ShopDTO;
import md.vcroitor.licenta.server.persistence.Address;
import md.vcroitor.licenta.server.persistence.Contact;
import md.vcroitor.licenta.server.persistence.Shop;
import md.vcroitor.licenta.server.persistence.ShopInfo;
import md.vcroitor.licenta.server.service.ShopService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.HashSet;
import java.util.Set;

import static md.vcroitor.licenta.common.enums.ShopCategoryEnum.FASHION;
import static md.vcroitor.licenta.server.DummyObjects.*;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * User: Vitalie Croitor
 * Date: 4/22/13
 * Time: 3:04 PM
 */
public class ShopFacadeImplTest {

    @InjectMocks
    private ShopFacadeImpl shopFacade;

    @Mock
    private ShopService shopService;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testGetById() throws Exception {
        Set<String> phones = new HashSet<>();
        phones.add("+37360380273");

        Set<String> emails = new HashSet<>();
        emails.add("abc@abc.com");

        Set<String> faxes = new HashSet<>();
        faxes.add("fax@fax");

        Contact contact = dummyContact(emails, phones, faxes);
        Address address = dummyAddress("MD", "Chisinau", "Pushkin", 3212, contact);
        Set<Address> addresses = new HashSet<>();
        addresses.add(address);
        ShopInfo shopInfo = dummyShopInfo(address, addresses, "http://some.com", "Super shop");
        Shop shop = dummyShop("shop1", "Shop Mania", shopInfo, FASHION, 3);

        when(shopService.getById(anyString())).thenReturn(shop);
        ShopDTO shopDTO = shopFacade.getById("shop1");

        assertThat(shopDTO.getId(), equalTo(shop.getId()));
        assertThat(shopDTO.getName(), equalTo(shop.getName()));
        assertThat(shopDTO.getInfo().getUrl(), equalTo(shop.getInfo().getUrl()));
        assertThat(shopDTO.getInfo().getMainAddress().getStreet(), equalTo(shop.getInfo().getMainAddress().getStreet()));
        assertThat(shopDTO.getInfo().getMainAddress().getContact().getEmail().iterator().next(), equalTo(shopDTO.getInfo().getMainAddress().getContact().getEmail().iterator().next()));
        assertThat(shopDTO.getInfo().getAddress().iterator().next().getContact().getPhone().iterator().next(), equalTo(shop.getInfo().getAddress().iterator().next().getContact().getPhone().iterator().next()));
    }
}
