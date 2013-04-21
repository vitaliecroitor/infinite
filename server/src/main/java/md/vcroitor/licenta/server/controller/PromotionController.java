package md.vcroitor.licenta.server.controller;

import md.vcroitor.licenta.common.dto.PromotionDTO;
import md.vcroitor.licenta.common.dto.Request;
import md.vcroitor.licenta.common.dto.Response;
import md.vcroitor.licenta.common.enums.ErrorEnum;
import md.vcroitor.licenta.common.enums.PromotionStatusEnum;
import md.vcroitor.licenta.server.dao.ShopDAO;
import md.vcroitor.licenta.server.facade.PromotionFacade;
import md.vcroitor.licenta.server.persistence.Promotion;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.util.Set;

import static md.vcroitor.licenta.common.enums.ErrorEnum.PROMOTION_NOT_FOUND;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 11:27 AM
 */
@Controller
@RequestMapping(value = "/promotion")
public class PromotionController extends GenericController {

    private static final Logger log = Logger.getLogger(PromotionController.class);

    @Resource(name = "promotionFacade")
    private PromotionFacade promotionFacade;

    @RequestMapping(value = "/get", method = POST)
    @ResponseBody
    public Response<Promotion> getById(@RequestBody @Valid Request<String> request) {
        log.info("Get by id:" + request.getObject());
        Promotion result = promotionFacade.getById(request.getObject());
        return result == null ? new Response<Promotion>(PROMOTION_NOT_FOUND): new Response<>(result);
    }

    @RequestMapping(value = "/getByShop", method = POST)
    @ResponseBody
    public Response<Set<PromotionDTO>> getByShop(@RequestBody @Valid Request<String> request) throws Exception{
        log.info("Get shop by id:" + request.getObject());
        return new Response<>(promotionFacade.getByShopId(request.getObject()));
    }

    @RequestMapping(value = "/getByStatus", method = POST)
    @ResponseBody
    public Response<Set<PromotionDTO>> getByStatus(@RequestBody @Valid Request<PromotionStatusEnum> request) throws Exception{
        log.info("Get by status:" + request.getObject());
        return new Response<>( promotionFacade.getByStatus(request.getObject()));
    }
}