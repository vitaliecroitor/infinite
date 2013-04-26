package md.vcroitor.licenta.server.controller;

import md.vcroitor.licenta.common.dto.Request;
import md.vcroitor.licenta.common.dto.Response;
import md.vcroitor.licenta.common.dto.ShopDTO;
import md.vcroitor.licenta.common.dto.request.PagerRequest;
import md.vcroitor.licenta.server.dao.ShopDAO;
import md.vcroitor.licenta.server.facade.ShopFacade;
import md.vcroitor.licenta.server.persistence.Shop;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.util.Set;

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

    @Resource(name = "shopDAO")
    private ShopDAO shopDAO;

    @RequestMapping(value = "/get", method = POST)
    @ResponseBody
    public Response<ShopDTO> getById(@RequestBody @Valid Request<String> request) throws Exception {
        return new Response<>(shopFacade.getById(request.getObject()));
    }

    @RequestMapping(value = "/add", method = POST)
    @ResponseBody
    public Response<?> add(@RequestBody Shop shop) {
        shopDAO.create(shop);
        return new Response<>();
    }

    @RequestMapping(value = "/list", method = POST)
    public Response<Set<ShopDTO>> list(@RequestBody @Valid Request<PagerRequest> request) throws Exception{
        return new Response<>(shopFacade.list(request.getObject().getOffset(), request.getObject().getLimit()));
    }
}
