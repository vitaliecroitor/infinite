package md.vcroitor.licenta.server.facade.impl;

import md.vcroitor.licenta.common.dto.PromotionDTO;
import md.vcroitor.licenta.common.enums.PromotionStatusEnum;
import md.vcroitor.licenta.server.persistence.Promotion;
import md.vcroitor.licenta.server.service.PromotionService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;

import java.util.HashSet;
import java.util.Set;

import static md.vcroitor.licenta.common.enums.PromotionCategoryEnum.P_FOOD;
import static md.vcroitor.licenta.common.enums.PromotionStatusEnum.AVAILABLE;
import static md.vcroitor.licenta.server.DummyObjects.dummyPromotion;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * User: Vitalie Croitor
 * Date: 4/22/13
 * Time: 9:34 AM
 */
public class PromotionFacadeImplTest {

    @InjectMocks
    private PromotionFacadeImpl promotionFacade;

    @Mock
    private PromotionService promotionService;


    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void testGetById() throws Exception {
        Promotion promotion = dummyPromotion("id", null, null, 321, 123, AVAILABLE, P_FOOD, null, null);
        when(promotionService.getById(Matchers.anyString())).thenReturn(promotion);

        PromotionDTO promotionDTO = promotionFacade.getById("id");
        assertThat(promotion.getId(), equalTo(promotionDTO.getId()));
    }

    @Test
    public void testGetByShopId() throws Exception {
        Promotion promotion = dummyPromotion("id", null, null, 321, 123, AVAILABLE, P_FOOD, null, null);
        Set<Promotion> promotions = new HashSet<>();
        promotions.add(promotion);

        when(promotionService.getByShopId(anyString())).thenReturn(promotions);
        Set<PromotionDTO> result = promotionFacade.getByShopId("shopId");

        assertThat(result.iterator().next().getId(), equalTo(promotions.iterator().next().getId()));
    }

    @Test
    public void testGetByStatus() throws Exception {
        Promotion promotion = dummyPromotion("id", null, null, 321, 123, AVAILABLE, P_FOOD, null, null);
        Set<Promotion> promotions = new HashSet<>();
        promotions.add(promotion);

        when(promotionService.getByStatus(isA(PromotionStatusEnum.class))).thenReturn(promotions);
        Set<PromotionDTO> result = promotionFacade.getByShopId("shopId");

        assertThat(result.iterator().next().getId(), equalTo(promotions.iterator().next().getId()));
        assertThat(result.iterator().next().getStatus(), equalTo(promotions.iterator().next().getStatus()));
    }
}