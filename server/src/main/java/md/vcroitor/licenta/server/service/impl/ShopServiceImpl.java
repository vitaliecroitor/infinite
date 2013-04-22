package md.vcroitor.licenta.server.service.impl;

import md.vcroitor.licenta.server.dao.ShopDAO;
import md.vcroitor.licenta.server.persistence.Shop;
import md.vcroitor.licenta.server.service.ShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * User: Vitalie Croitor
 * Date: 4/22/13
 * Time: 2:05 PM
 */
@Service("shopService")
public class ShopServiceImpl implements ShopService {

    @Resource(name = "shopDAO")
    private ShopDAO shopDAO;

    @Override
    public void create(Shop shop) {
        shopDAO.create(shop);
    }

    @Override
    public Shop getById(String id) {
        return shopDAO.getById(id);
    }
}
