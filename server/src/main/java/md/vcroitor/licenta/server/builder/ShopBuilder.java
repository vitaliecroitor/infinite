package md.vcroitor.licenta.server.builder;

import md.vcroitor.licenta.common.dto.ShopDTO;
import md.vcroitor.licenta.common.dto.ShopInfoDTO;
import md.vcroitor.licenta.server.persistence.Shop;

import java.lang.reflect.InvocationTargetException;

import static org.springframework.beans.BeanUtils.copyProperties;


/**
 * User: Vitalie Croitor
 * Date: 4/22/13
 * Time: 2:08 PM
 */
public class ShopBuilder {

    public static void toDTO(final Shop shop, final ShopDTO shopDTO) throws InvocationTargetException, IllegalAccessException {
        copyProperties(shop, shopDTO, new String[]{"info"});

        // copy shop info as well
        ShopInfoDTO shopInfoDTO = new ShopInfoDTO();
        ShopInfoBuilder.toDTO(shop.getInfo(), shopInfoDTO);
        shopDTO.setInfo(shopInfoDTO);
    }
}
