package md.vcroitor.licenta.server.dao;

import md.vcroitor.licenta.common.enums.PromotionCategoryEnum;
import md.vcroitor.licenta.common.enums.PromotionStatusEnum;
import md.vcroitor.licenta.server.persistence.Promotion;

import java.util.Date;
import java.util.Set;

public interface PromotionDAO {
    void create(final Promotion promotion);
    void delete(final Promotion promotion);
    Promotion getById(final String id);
    void deleteById(final String id);
    Set<Promotion> getByShopId(final String shopId);
    Set<Promotion> getByStatus(final PromotionStatusEnum status);
    Set<Promotion> getByCategory(final PromotionCategoryEnum category);
    Set<Promotion> getByPeriod(final Date from, final Date to);
}
