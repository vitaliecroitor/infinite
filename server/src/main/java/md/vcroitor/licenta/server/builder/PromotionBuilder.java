package md.vcroitor.licenta.server.builder;

import md.vcroitor.licenta.common.dto.PromotionDTO;
import md.vcroitor.licenta.server.persistence.Promotion;

import java.lang.reflect.InvocationTargetException;

import static org.springframework.beans.BeanUtils.copyProperties;

/**
 * User: Vitalie Croitor
 * Date: 4/21/13
 * Time: 1:03 PM
 */
public class PromotionBuilder {

    public static void fromDTO(final Promotion promotion, final PromotionDTO promotionDTO) throws InvocationTargetException, IllegalAccessException {
        copyProperties(promotionDTO, promotion, new String[]{"info"});
        // ignore manual set id
        promotion.setId(null);
    }

    public static void toDTO(final Promotion promotion, final PromotionDTO promotionDTO) throws InvocationTargetException, IllegalAccessException {
        copyProperties(promotion, promotionDTO, new String[]{"info"});
        promotionDTO.setShopId(promotion.getShop().getId());
    }
}
