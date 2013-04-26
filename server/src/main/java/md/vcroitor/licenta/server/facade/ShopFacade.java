package md.vcroitor.licenta.server.facade;

import md.vcroitor.licenta.common.dto.ShopDTO;

import java.util.Set;

/**
 * User: Vitalie Croitor
 * Date: 4/22/13
 * Time: 2:02 PM
 */
public interface ShopFacade {

    void create(ShopDTO shopDTO);
    ShopDTO getById(String id) throws Exception;

    Set<ShopDTO> list(int offset, int limit)throws Exception;
}
