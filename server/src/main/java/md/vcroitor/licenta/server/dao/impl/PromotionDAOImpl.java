package md.vcroitor.licenta.server.dao.impl;

import md.vcroitor.licenta.common.enums.PromotionCategoryEnum;
import md.vcroitor.licenta.common.enums.PromotionStatusEnum;
import md.vcroitor.licenta.server.dao.AbstractDAO;
import md.vcroitor.licenta.server.dao.PromotionDAO;
import md.vcroitor.licenta.server.persistence.Promotion;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashSet;
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
    public Set<Promotion> getByShopId(final String shopId) {
        return new HashSet<>(getMongoOperations().find(new Query(new Criteria("shop.$id").is(new ObjectId(shopId))), Promotion.class));
    }

    @Override
    public Set<Promotion> getByStatus(final PromotionStatusEnum status) {
        return new HashSet<>(getMongoOperations().find(new Query(new Criteria("status").is(status.toString())), Promotion.class));
    }

    @Override
    public Set<Promotion> getByCategory(final PromotionCategoryEnum category) {
        return new HashSet<>(getMongoOperations().find(new Query(new Criteria("category").is(category.toString())), Promotion.class));
    }

    @Override
    public Set<Promotion> getByPeriod(final Date from, final Date to) {
        return new HashSet<>(getMongoOperations().find(new Query(Criteria.where("expireDate").gte(from).lte(to)), Promotion.class));
    }
}