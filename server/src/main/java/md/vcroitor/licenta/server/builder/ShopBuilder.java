package md.vcroitor.licenta.server.builder;

import md.vcroitor.licenta.common.dto.ShopDTO;
import md.vcroitor.licenta.server.persistence.Shop;

import java.lang.reflect.InvocationTargetException;

import static org.apache.commons.beanutils.BeanUtils.copyProperties;

/**
 * User: Vitalie Croitor
 * Date: 4/22/13
 * Time: 2:08 PM
 */
public class ShopBuilder {

    public static void fromDTO(final Shop shop, final ShopDTO shopDTO) throws InvocationTargetException, IllegalAccessException {
        copyProperties(shop, shopDTO);
        // ignore manual set id
        shop.setId(null);
    }

    public static void toDTO(final Shop shop, final ShopDTO shopDTO) throws InvocationTargetException, IllegalAccessException {
        copyProperties(shopDTO, shop);
    }
}
