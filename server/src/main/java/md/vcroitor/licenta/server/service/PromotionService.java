package md.vcroitor.licenta.server.service;

import md.vcroitor.licenta.server.persistence.Promotion;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 11:29 AM
 */
public interface PromotionService {
    Promotion getById(long id);
}
