package md.vcroitor.licenta.server.dao.impl;

import md.vcroitor.licenta.server.dao.AbstractDAO;
import md.vcroitor.licenta.server.dao.ShopDAO;
import md.vcroitor.licenta.server.persistence.Shop;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

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

    public Set<Shop> getPage(int offset, int limit){
        return new HashSet<>(getMongoOperations().find(new Query().skip(offset).limit(limit), Shop.class));
    }

    @Override
    public Set<Shop> getAll() {
        return new HashSet<>(getMongoOperations().findAll(Shop.class));
    }
}