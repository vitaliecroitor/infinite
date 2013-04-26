package md.vcroitor.licenta.server.service;

import md.vcroitor.licenta.server.persistence.Shop;

import java.util.Date;
import java.util.Set;

/**
 * User: Vitalie Croitor
 * Date: 4/22/13
 * Time: 2:04 PM
 */
public interface ShopService {
    void create(Shop shop);
    Shop getById(String id);
    Set<Shop> list(int offset, int limit);
}
