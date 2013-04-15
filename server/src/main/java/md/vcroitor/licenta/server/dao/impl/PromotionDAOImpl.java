package md.vcroitor.licenta.server.dao.impl;

import md.vcroitor.licenta.common.enums.PromotionCategory;
import md.vcroitor.licenta.common.enums.PromotionStatus;
import md.vcroitor.licenta.server.dao.AbstractDAO;
import md.vcroitor.licenta.server.dao.PromotionDAO;
import md.vcroitor.licenta.server.persistence.Promotion;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 10:53 AM
 */
@Repository("promotionDAO")
@Transactional(propagation = REQUIRED)
public class PromotionDAOImpl extends AbstractDAO<Promotion> implements PromotionDAO {

    public PromotionDAOImpl() {
        super(Promotion.class);
    }

    @Override
    public Set<Promotion> getByShopId(String shopId) {

        List<Promotion> result = getMongoOperations().find(query(where("shop").is(shopId)) , Promotion.class);

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