package md.vcroitor.licenta.server.controller;

import md.vcroitor.licenta.common.enums.PromotionCategory;
import md.vcroitor.licenta.common.enums.PromotionStatus;
import md.vcroitor.licenta.server.persistence.Promotion;
import md.vcroitor.licenta.common.dto.Request;
import md.vcroitor.licenta.common.dto.Response;
import md.vcroitor.licenta.server.facade.PromotionFacade;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
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
    PromotionFacade promotionFacade;

    @RequestMapping(value = "/get", method = POST)
    public Response<Promotion> getById(@Valid Request<String> request) {
        return new Response<>(promotionFacade.getById(request.getObject()));
    }

    @RequestMapping(value = "/test", method = GET)
    public void test(){
        log.info("-----------------------------I'm here naaaaaaaa");
        Promotion p = new Promotion();
        p.setCategory(PromotionCategory.TEST);
        p.setCreatedDate(new Date());
        p.setExpireDate(new Date());
        p.setNewPrice(2.2);
        p.setOldPrice(5.3);
        p.setStatus(PromotionStatus.AVAILABLE);
        promotionFacade.create(p);
        log.info(p.getId());
        Promotion res = promotionFacade.getById(p.getId());
        log.info("res id: " + res.getId());
        log.info("res status:" + res.getStatus());
    }
}