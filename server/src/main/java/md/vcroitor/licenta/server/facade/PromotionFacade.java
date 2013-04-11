package md.vcroitor.licenta.server.facade;

import md.vcroitor.licenta.server.persistence.Promotion;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 11:28 AM
 */
public interface PromotionFacade {
    Promotion getById(String id);
    void create(Promotion p);
}
