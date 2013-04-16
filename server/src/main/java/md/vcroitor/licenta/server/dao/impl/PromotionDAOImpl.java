package md.vcroitor.licenta.server.dao.impl;

import md.vcroitor.licenta.common.enums.PromotionCategory;
import md.vcroitor.licenta.common.enums.PromotionStatus;
import md.vcroitor.licenta.server.dao.AbstractDAO;
import md.vcroitor.licenta.server.dao.PromotionDAO;
import md.vcroitor.licenta.server.persistence.Promotion;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 10:53 AM
 */
@Repository("promotionDAO")
//@Transactional(propagation = REQUIRED)
public class PromotionDAOImpl extends AbstractDAO<Promotion> implements PromotionDAO {

    public PromotionDAOImpl() {
        super(Promotion.class);
    }

    @Override
    public Set<Promotion> getByShopId(String shopId) {

        Query query = new Query(new Criteria("shop.$id").is(new ObjectId(shopId)));

        List<Promotion> result = getMongoOperations().find(query, Promotion.class);

        return new HashSet<>(result);
    }

    @Override
    public Set<Promotion> getByStatus(PromotionStatus status) {
        return null;
    }

    @Override
    public Set<Promotion> getByCategory(PromotionCategory category) {
        return null;
    }

    @Override
    public Set<Promotion> getByPeriod(Date from, Date to) {
        return null;
    }
}