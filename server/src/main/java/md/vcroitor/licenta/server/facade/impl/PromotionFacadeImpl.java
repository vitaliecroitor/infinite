package md.vcroitor.licenta.server.facade.impl;

import md.vcroitor.licenta.server.persistence.Promotion;
import md.vcroitor.licenta.server.facade.PromotionFacade;
import md.vcroitor.licenta.server.service.PromotionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 11:28 AM
 */
@Service("promotionFacade")
public class PromotionFacadeImpl implements PromotionFacade {

    @Resource(name = "promotionService")
    PromotionService promotionService;

    @Override
    public Promotion getById(String id) {
        return promotionService.getById(id);
    }

    @Override
    public void create(Promotion p) {
        promotionService.create(p);
    }

    @Override
    public void deleteById(String id){
        promotionService.deleteById(id);
    }

    @Override
    public void delete(Promotion promotion) {
       promotionService.delete(promotion);
    }
}
