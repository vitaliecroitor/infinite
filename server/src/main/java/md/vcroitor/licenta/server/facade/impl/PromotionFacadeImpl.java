package md.vcroitor.licenta.server.facade.impl;

import md.vcroitor.licenta.common.dto.PromotionDTO;
import md.vcroitor.licenta.common.enums.PromotionStatusEnum;
import md.vcroitor.licenta.server.builder.PromotionBuilder;
import md.vcroitor.licenta.server.facade.PromotionFacade;
import md.vcroitor.licenta.server.persistence.Promotion;
import md.vcroitor.licenta.server.service.PromotionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

import static md.vcroitor.licenta.server.builder.PromotionBuilder.toDTO;

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
    public PromotionDTO getById(String id) throws Exception{
        Promotion promotion = promotionService.getById(id);
        return convert(promotion);
    }

    @Override
    public void create(Promotion p) {
        promotionService.create(p);
    }

    @Override
    public void deleteById(String id) {
        promotionService.deleteById(id);
    }

    @Override
    public void delete(Promotion promotion) {
        promotionService.delete(promotion);
    }

    @Override
    public Set<PromotionDTO> getByShopId(String shopId) throws Exception {
        Set<Promotion> promotions = promotionService.getByShopId(shopId);
        return convert(promotions);
    }

    @Override
    public Set<PromotionDTO> getByStatus(PromotionStatusEnum status) throws Exception{
        Set<Promotion> promotions = promotionService.getByStatus(status);
        return convert(promotions);
    }

    /**
     * @throws Exception on converting beans
     * <p>converts a set of Promotion persistence objects to a set of PromotionDTO objects</p>
     */
    private Set<PromotionDTO> convert(Set<Promotion> from) throws Exception {
        Set<PromotionDTO> result = new HashSet<>();

        for (Promotion promotion : from) {
            PromotionDTO promotionDTO = new PromotionDTO();
            toDTO(promotion, promotionDTO);
            result.add(promotionDTO);
        }

        return result;
    }

    /**
     * @return PromotionDTO object
     * @throws Exception on converting beans
     * <p>converts a single Promotion object to a DTO promotion object</p>
     */
    private PromotionDTO convert(Promotion promotion) throws Exception{
        PromotionDTO promotionDTO = new PromotionDTO();
        toDTO(promotion, promotionDTO);

        return promotionDTO;
    }
}