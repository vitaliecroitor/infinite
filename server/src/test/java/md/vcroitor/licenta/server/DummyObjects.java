package md.vcroitor.licenta.server;

import md.vcroitor.licenta.common.dto.*;
import md.vcroitor.licenta.common.enums.PromotionCategoryEnum;
import md.vcroitor.licenta.common.enums.PromotionStatusEnum;
import md.vcroitor.licenta.common.enums.ShopCategoryEnum;
import md.vcroitor.licenta.server.persistence.*;

import java.util.Date;
import java.util.Set;

/**
 * User: Vitalie Croitor
 * Date: 4/16/13
 * Time: 11:35 AM
 */
public class DummyObjects {

    public static Promotion dummyPromotion(String id, Date createdDate, Date expireDate, int oldPrice,
                                           int newPrice, PromotionStatusEnum status, PromotionCategoryEnum category, PromotionInfo promotionInfo, Shop shop) {
        Promotion promotion = new Promotion();
        promotion.setId(id);
        promotion.setCreatedDate(createdDate);
        promotion.setExpireDate(expireDate);
        promotion.setOldPrice(oldPrice);
        promotion.setNewPrice(newPrice);
        promotion.setInfo(promotionInfo);
        promotion.setStatus(status);
        promotion.setShop(shop);
        promotion.setCategory(category);

        return promotion;
    }

    public static PromotionDTO dummyPromotionDTO(String id, Date createdDate, Date expireDate, int oldPrice,
                                                 int newPrice, PromotionStatusEnum status, PromotionCategoryEnum category, String shopId) {
        PromotionDTO promotionDTO = new PromotionDTO();
        promotionDTO.setId(id);
        promotionDTO.setCreatedDate(createdDate);
        promotionDTO.setExpireDate(expireDate);
        promotionDTO.setOldPrice(oldPrice);
        promotionDTO.setNewPrice(newPrice);
        promotionDTO.setStatus(status);
        promotionDTO.setShopId(shopId);
        promotionDTO.setCategory(category);

        return promotionDTO;
    }

    public static Shop dummyShop(String id, String name, ShopInfo info, ShopCategoryEnum category, int rating) {
        Shop shop = new Shop();
        shop.setRating(rating);
        shop.setName(name);
        shop.setCategory(category);
        shop.setId(id);
        shop.setInfo(info);

        return shop;
    }

    public static ShopDTO dummyShopDTO(String id, String name, ShopInfoDTO info, ShopCategoryEnum category, int rating) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setRating(rating);
        shopDTO.setName(name);
        shopDTO.setCategory(category);
        shopDTO.setId(id);
        shopDTO.setInfo(info);

        return shopDTO;
    }

    public static Address dummyAddress(String country, String city, String street, int zip, Contact contact) {
        Address address = new Address();
        address.setContact(contact);
        address.setZip(zip);
        address.setStreet(street);
        address.setCountry(country);
        address.setCity(city);

        return address;
    }

    public static AddressDTO dummyAddressDTO(String country, String city, String street, int zip, ContactDTO contact) {

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setContact(contact);
        addressDTO.setZip(zip);
        addressDTO.setStreet(street);
        addressDTO.setCountry(country);
        addressDTO.setCity(city);

        return addressDTO;
    }

    public static Contact dummyContact(Set<String> emails, Set<String> phones, Set<String> faxes) {
        Contact contact = new Contact();
        contact.setEmail(emails);
        contact.setPhone(phones);
        contact.setFax(faxes);

        return contact;
    }

    public static ContactDTO dummyContactDTO(Set<String> emails, Set<String> phones, Set<String> faxes) {
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setEmail(emails);
        contactDTO.setPhone(phones);
        contactDTO.setFax(faxes);

        return contactDTO;
    }

    public static ShopInfo dummyShopInfo(Address mainAddress, Set<Address> address, String url, String description) {
        ShopInfo shopInfo = new ShopInfo();
        shopInfo.setMainAddress(mainAddress);
        shopInfo.setAddress(address);
        shopInfo.setUrl(url);
        shopInfo.setDescription(description);


        return shopInfo;
    }

    public static ShopInfoDTO dummyShopInfoDTO(AddressDTO mainAddress, Set<AddressDTO> address, String url, String description) {

        ShopInfoDTO shopInfoDTO = new ShopInfoDTO();
        shopInfoDTO.setMainAddress(mainAddress);
        shopInfoDTO.setAddress(address);
        shopInfoDTO.setUrl(url);
        shopInfoDTO.setDescription(description);


        return shopInfoDTO;
    }

    public static PromotionInfo dummyPromotionInfo(String description) {
        PromotionInfo promotionInfo = new PromotionInfo();
        promotionInfo.setDescription(description);

        return promotionInfo;
    }

    public static PromotionInfoDTO dummyPromotionInfoDTO(String description) {
        PromotionInfoDTO promotionInfoDTO = new PromotionInfoDTO();
        promotionInfoDTO.setDescription(description);

        return promotionInfoDTO;
    }
}
