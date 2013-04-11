package md.vcroitor.licenta.server.dao;

import md.vcroitor.licenta.common.enums.PromotionCategory;
import md.vcroitor.licenta.common.enums.PromotionStatus;
import md.vcroitor.licenta.server.persistence.Promotion;

import java.util.Date;
import java.util.Set;

public interface PromotionDAO {

    Promotion getById(long id);
    Set<Promotion> getByShopId(long shopId);
    Set<Promotion> getByStatus(PromotionStatus status);
    Set<Promotion> getByCategory(PromotionCategory category);
    Set<Promotion> getByPeriod(Date from, Date to);
}