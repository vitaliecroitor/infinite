package md.vcroitor.licenta.server.controller;

import md.vcroitor.licenta.common.dto.Request;
import md.vcroitor.licenta.common.dto.Response;
import md.vcroitor.licenta.common.dto.ShopDTO;
import md.vcroitor.licenta.server.facade.ShopFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import javax.annotation.Resource;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * User: Vitalie Croitor
 * Date: 4/22/13
 * Time: 1:57 PM
 */
@Controller
@RequestMapping("/shop")
public class ShopController extends GenericController {

    @Resource(name = "shopFacade")
    private ShopFacade shopFacade;

    @RequestMapping(value = "/get", method = POST)
    @ResponseBody
    public Response<ShopDTO> getById(@RequestBody @Valid Request<String> request) throws Exception{
        return new Response<>(shopFacade.getById(request.getObject()));
    }
}
