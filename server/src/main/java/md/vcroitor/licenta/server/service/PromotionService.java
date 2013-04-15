package md.vcroitor.licenta.server.service;

import md.vcroitor.licenta.server.persistence.Promotion;

import java.util.Set;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 11:29 AM
 */
public interface PromotionService {
    Promotion getById(String id);
    void create(Promotion promotion);
    void deleteById(String id);
    void delete(Promotion promotion);
}
