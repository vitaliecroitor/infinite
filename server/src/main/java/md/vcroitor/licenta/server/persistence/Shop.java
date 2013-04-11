package md.vcroitor.licenta.server.persistence;

import md.vcroitor.licenta.server.enums.ShopCategory;

import java.util.Set;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 9:43 AM
 */
public class Shop {

    protected long id;
    protected String name;
    protected Set<Address> addresses;
    protected ShopInfo info;
    protected Set<Promotion> promotions;
    protected ShopCategory category;
}