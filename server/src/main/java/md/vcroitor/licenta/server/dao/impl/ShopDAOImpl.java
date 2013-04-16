package md.vcroitor.licenta.server.dao.impl;

import md.vcroitor.licenta.server.dao.AbstractDAO;
import md.vcroitor.licenta.server.dao.ShopDAO;
import md.vcroitor.licenta.server.persistence.Shop;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

/**
 * User: Vitalie Croitor
 * Date: 4/15/13
 * Time: 2:31 PM
 */
@Repository("shopDAO")
//@Transactional(propagation = REQUIRED)
public class ShopDAOImpl extends AbstractDAO<Shop> implements ShopDAO{

    public ShopDAOImpl(){
        super(Shop.class);
    }
}
