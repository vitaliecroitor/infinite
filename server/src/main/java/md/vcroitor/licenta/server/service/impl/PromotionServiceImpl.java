package md.vcroitor.licenta.server.service.impl;

import md.vcroitor.licenta.server.dao.PromotionDAO;
import md.vcroitor.licenta.server.persistence.Promotion;
import md.vcroitor.licenta.server.service.PromotionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    public Promotion getById(long id) {
        return promotionDAO.getById(id);
    }
}