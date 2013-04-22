package md.vcroitor.licenta.server.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import md.vcroitor.licenta.common.dto.AddressDTO;
import md.vcroitor.licenta.common.dto.Request;
import md.vcroitor.licenta.common.dto.ShopDTO;
import md.vcroitor.licenta.common.dto.ShopInfoDTO;
import md.vcroitor.licenta.common.enums.ShopCategoryEnum;
import md.vcroitor.licenta.server.DummyObjects;
import md.vcroitor.licenta.server.facade.ShopFacade;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;

import static md.vcroitor.licenta.common.enums.ResponseStatusEnum.OK;
import static md.vcroitor.licenta.common.enums.ShopCategoryEnum.*;
import static md.vcroitor.licenta.server.DummyObjects.dummyShopDTO;
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
 * User: Vitalie Croitor
 * Date: 4/22/13
 * Time: 2:34 PM
 */
public class ShopControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private ShopController shopController;

    @Mock
    private ShopFacade shopFacade;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        this.mockMvc = standaloneSetup(shopController).build();
    }

    @Test
    public void testGetById() throws Exception {
        ShopDTO shopDTO = dummyShopDTO("shopId", "Shop1", null, FASHION, 3);
        when(shopFacade.getById(anyString())).thenReturn(shopDTO);

        ObjectMapper mapper = new ObjectMapper();
        String object = mapper.writeValueAsString(new Request<>("shopId"));

        this.mockMvc.perform(post("/shop/get").contentType(APPLICATION_JSON)
                .content(object.getBytes()))
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$status", equalTo(OK.toString())))
                .andExpect(jsonPath("object.id", equalTo(shopDTO.getId())));
    }
}
