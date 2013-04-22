package md.vcroitor.licenta.server.controller;

import md.vcroitor.licenta.common.dto.Request;
import md.vcroitor.licenta.common.dto.Response;
import md.vcroitor.licenta.common.enums.ImageType;
import md.vcroitor.licenta.server.service.ImageService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * User: Vitalie Croitor
 * Date: 4/22/13
 * Time: 10:00 AM
 */
@Controller
@RequestMapping("/image")
public class ImageController extends GenericController {

    private static final Logger log = Logger.getLogger(ImageController.class);

    @Resource(name = "imageService")
    private ImageService imageService;

    @RequestMapping(value = "/promotion/{shopId}_{promotionId}_{imageType}.png", method = GET)
    @ResponseBody
    public byte[] getPromotionImage(@PathVariable String shopId, @PathVariable String promotionId, @PathVariable ImageType imageType) throws Exception {
        log.info("promotion image: " + shopId + "   " + promotionId + "  " + imageType.toString());
        return imageService.getPromotionImage(shopId, promotionId, imageType);
    }

    @RequestMapping(value = "/shop/{shopId}_{imageType}.png", method = GET)
    @ResponseBody
    public byte[] getShopImage(@PathVariable String shopId, @PathVariable ImageType imageType) throws Exception {
        log.info("shop image: " + shopId + "   " + imageType.toString());
        return imageService.getShopImage(shopId, imageType);
    }
}