package md.vcroitor.licenta.server.controller;

import md.vcroitor.licenta.server.persistence.Promotion;
import md.vcroitor.licenta.common.dto.Request;
import md.vcroitor.licenta.common.dto.Response;
import md.vcroitor.licenta.server.facade.PromotionFacade;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 11:27 AM
 */
@RequestMapping(value = "/promotion")
public class PromotionController extends GenericController {

    @Resource(name = "promotionFacade")
    PromotionFacade promotionFacade;

    @RequestMapping(value = "/get", method = POST)
    public Response<Promotion> getById(@Valid Request<Long> request) {
        return new Response<>(promotionFacade.getById(request.getObject()));
    }
}