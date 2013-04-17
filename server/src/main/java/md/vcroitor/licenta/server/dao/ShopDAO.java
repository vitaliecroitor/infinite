package md.vcroitor.licenta.server.dao;

import md.vcroitor.licenta.server.persistence.Shop;

import java.util.Set;

/**
 * User: Vitalie Croitor
 * Date: 4/15/13
 * Time: 2:31 PM
 */
public interface ShopDAO {
    void create(Shop shop);
    Shop getById(String id);
    Set<Shop> getPage(int offset, int limit);
    Set<Shop> getAll();
}
