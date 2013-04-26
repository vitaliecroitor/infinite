package md.vcroitor.licenta.server.facade.impl;

import md.vcroitor.licenta.common.dto.ShopDTO;
import md.vcroitor.licenta.server.builder.ShopBuilder;
import md.vcroitor.licenta.server.facade.ShopFacade;
import md.vcroitor.licenta.server.persistence.Shop;
import md.vcroitor.licenta.server.service.ShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

import static md.vcroitor.licenta.server.builder.ShopBuilder.toDTO;

/**
 * User: Vitalie Croitor
 * Date: 4/22/13
 * Time: 2:02 PM
 */
@Service("shopFacade")
public class ShopFacadeImpl implements ShopFacade {

    @Resource(name = "shopService")
    private ShopService shopService;

    @Override
    public void create(ShopDTO shopDTO) {
    }

    @Override
    public ShopDTO getById(String id) throws Exception {
        return convert(shopService.getById(id));
    }

    @Override
    public Set<ShopDTO> list(int offset, int limit) throws Exception {
        return convert(shopService.list(offset, limit));
    }

    private Set<ShopDTO> convert(Set<Shop> shops) throws Exception {
        Set<ShopDTO> result = new HashSet<>();
        for (Shop shop : shops) {
            ShopDTO shopDTO = new ShopDTO();
            ShopBuilder.toDTO(shop, shopDTO);
            result.add(shopDTO);
        }

        return result;
    }

    private ShopDTO convert(Shop shop) throws Exception {
        ShopDTO shopDTO = new ShopDTO();
        toDTO(shop, shopDTO);

        return shopDTO;
    }
}