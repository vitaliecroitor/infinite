package md.vcroitor.licenta.server.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import md.vcroitor.licenta.common.dto.PromotionDTO;
import md.vcroitor.licenta.common.dto.Request;
import md.vcroitor.licenta.common.enums.ResponseStatusEnum;
import md.vcroitor.licenta.server.DummyObjects;
import md.vcroitor.licenta.server.facade.PromotionFacade;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static md.vcroitor.licenta.common.enums.PromotionCategoryEnum.P_FOOD;
import static md.vcroitor.licenta.common.enums.PromotionStatusEnum.AVAILABLE;
import static md.vcroitor.licenta.common.enums.ResponseStatusEnum.*;
import static md.vcroitor.licenta.server.DummyObjects.*;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created with IntelliJ IDEA.
 * User: vcroitor
 * Date: 4/21/13
 * Time: 5:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class PromotionControllerTest{

    private MockMvc mockMvc;

    @InjectMocks
    private PromotionController promotionController;

    @Mock
    private PromotionFacade promotionFacade;


    @Before
    public void setUp() throws Exception {
        initMocks(this);
        mockMvc = standaloneSetup(promotionController).build();
    }

    @Test
    public void testGetById() throws Exception {
        PromotionDTO promotionDTO = dummyPromotionDTO("id", new Date(), new Date(), 123, 213, AVAILABLE, P_FOOD, "shop1");
        when(promotionFacade.getById(anyString())).thenReturn(promotionDTO);

        ObjectMapper mapper = new ObjectMapper();
        Request<String> request = new Request<>();
        request.setObject(promotionDTO.getId());
        String object = mapper.writeValueAsString(request);

        this.mockMvc.perform(post("/promotion/get").contentType(APPLICATION_JSON)
                .content(object.getBytes()))
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$status", equalTo(OK.toString())))
                .andExpect(jsonPath("object.id", equalTo(promotionDTO.getId())));
    }
}
