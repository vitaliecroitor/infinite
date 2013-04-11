package md.vcroitor.licenta.server.dao;

import md.vcroitor.licenta.common.enums.PromotionCategory;
import md.vcroitor.licenta.common.enums.PromotionStatus;
import md.vcroitor.licenta.server.persistence.Promotion;

import java.util.Date;
import java.util.Set;

public interface PromotionDAO {
    void create(final Promotion promotion);
    void delete(final Promotion promotion);
    Promotion getById(final long id);
    void deleteById(final long id);
    Set<Promotion> getByShopId(final long shopId);
    Set<Promotion> getByStatus(final PromotionStatus status);
    Set<Promotion> getByCategory(final PromotionCategory category);
    Set<Promotion> getByPeriod(final Date from, final Date to);
}
