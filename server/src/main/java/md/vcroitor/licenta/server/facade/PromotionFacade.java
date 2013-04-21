package md.vcroitor.licenta.server.facade;

import md.vcroitor.licenta.common.dto.PromotionDTO;
import md.vcroitor.licenta.common.enums.PromotionStatusEnum;
import md.vcroitor.licenta.server.persistence.Promotion;

import java.util.Set;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 11:28 AM
 */
public interface PromotionFacade {
    Promotion getById(String id);
    void create(Promotion promotion);
    void deleteById(String id);
    void delete(Promotion promotion);
    Set<PromotionDTO> getByShopId(String shopId) throws Exception;
    Set<PromotionDTO> getByStatus(PromotionStatusEnum status) throws Exception;
}
