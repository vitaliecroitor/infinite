package md.vcroitor.licenta.server.controller;

import md.vcroitor.licenta.common.enums.PromotionCategory;
import md.vcroitor.licenta.common.enums.PromotionStatus;
import md.vcroitor.licenta.common.enums.ShopCategory;
import md.vcroitor.licenta.server.dao.ShopDAO;
import md.vcroitor.licenta.server.persistence.*;
import md.vcroitor.licenta.common.dto.Request;
import md.vcroitor.licenta.common.dto.Response;
import md.vcroitor.licenta.server.facade.PromotionFacade;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 11:27 AM
 */
@Controller
@RequestMapping(value = "/promotion")
public class PromotionController extends GenericController {

    private static final Logger log = Logger.getLogger(PromotionController.class);

    @Resource(name = "promotionFacade")
    private PromotionFacade promotionFacade;

    @Resource(name ="shopDAO")
    private ShopDAO shopDAO;

    @RequestMapping(value = "/get", method = POST)
    public Response<Promotion> getById(@Valid Request<String> request) {
        return new Response<>(promotionFacade.getById(request.getObject()));
    }

    @RequestMapping(value = "/test", method = GET)
    public void test(){

        log.info("------------------ Intru test");

        Promotion p = new Promotion();
//        Shop shop = new Shop();
//        ShopInfo shopInfo = new ShopInfo();
//        Address mainAddress = new Address();
        PromotionInfo promotionInfo = new PromotionInfo();
//        Contact contact = new Contact();

        // setup shop
//        shop.setInfo(shopInfo);
//        shop.setCategory(ShopCategory.FUN);
//        shop.setName("Test");
//        shop.setRating(1);
//
//        //setup shop info
//        shopInfo.setDescription("some description");
//        shopInfo.setUrl("http://test.com");
//
//
//        // main address
//        mainAddress.setCity("Chisinau");
//        mainAddress.setCountry("MD");
//        mainAddress.setStreet("Pushchin");
//        mainAddress.setZip(1234);
//        mainAddress.setContact(contact);
//
//
//        // address
//        Address add1 = new Address();
//        add1.setCity("Chisinau");
//        add1.setCountry("MD");
//        add1.setStreet("Vieru");
//        add1.setZip(43212);
//        add1.setContact(contact);
//
//        Address add2 = new Address();
//        add2.setCity("Chisinau");
//        add2.setCountry("MD");
//        add2.setStreet("Vieru");
//        add2.setZip(43212);
//        add2.setContact(contact);
//
//        // addresses
//        Set<Address> addresses = new HashSet<>();
//        addresses.add(add1);
//        addresses.add(add2);
//
//        shopInfo.setMainAddress(mainAddress);
//        shopInfo.setAddress(addresses);

        //Contact
        // emails
//        Set<String> emails = new HashSet<>();
//        emails.add("first@first.com");
//        emails.add("second@second.com");
//
//        // phones
//        Set<String> phones = new HashSet<>();
//        phones.add("+37369818499");
//        phones.add("022261512");
//
//        // fax
//        Set<String> faxes = new HashSet<>();
//        faxes.add("fax1");
//        faxes.add("fax2");
//
//        //
//        contact.setEmail(emails);
//        contact.setPhone(phones);
//        contact.setFax(faxes);

        // promotion info
        promotionInfo.setDescription("description");

        p.setCategory(PromotionCategory.P_FOOD);
        p.setCreatedDate(new Date());
        p.setExpireDate(new Date());
        p.setInfo(promotionInfo);
        p.setNewPrice(12);
        p.setOldPrice(13);
        p.setStatus(PromotionStatus.AVAILABLE);
        p.setShop(shopDAO.getById("516bf909e4b0bebcdad1ae4d"));

       // shopDAO.create(shop);

        promotionFacade.create(p);

        promotionFacade.getById(p.getId());

        log.info("Got promotion:" + p.getShop().getName());

    }
}