package md.vcroitor.licenta.server.service.impl;

import md.vcroitor.licenta.common.enums.PromotionStatusEnum;
import md.vcroitor.licenta.server.dao.PromotionDAO;
import md.vcroitor.licenta.server.persistence.Promotion;
import md.vcroitor.licenta.server.service.PromotionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 11:29 AM
 */

@Service("promotionService")
public class PromotionServiceImpl implements PromotionService{

    @Resource(name = "promotionDAO")
    private PromotionDAO promotionDAO;

    @Override
    public Promotion getById(String id) {
        return promotionDAO.getById(id);
    }

    @Override
    public void create(Promotion promotion) {
        promotionDAO.create(promotion);
    }

    @Override
    public void deleteById(String id) {
        promotionDAO.deleteById(id);
    }

    @Override
    public void delete(Promotion promotion) {
        promotionDAO.delete(promotion);
    }

    @Override
    public Set<Promotion> getByShopId(String shopId){
        return  promotionDAO.getByShopId(shopId);
    }

    @Override
    public Set<Promotion> getByStatus(PromotionStatusEnum status) {
        return promotionDAO.getByStatus(status);
    }
}