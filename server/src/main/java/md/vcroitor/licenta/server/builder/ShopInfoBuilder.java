package md.vcroitor.licenta.server.builder;

import md.vcroitor.licenta.common.dto.AddressDTO;
import md.vcroitor.licenta.common.dto.ShopInfoDTO;
import md.vcroitor.licenta.server.persistence.Address;
import md.vcroitor.licenta.server.persistence.ShopInfo;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.beans.BeanUtils.copyProperties;

/**
 * User: Vitalie Croitor
 * Date: 4/23/13
 * Time: 12:21 PM
 */
public class ShopInfoBuilder {

    public static void toDTO(final ShopInfo shopInfo, final ShopInfoDTO shopInfoDTO) {
        copyProperties(shopInfo, shopInfoDTO, new String[]{"mainAddress", "address"});

        AddressDTO mainAddress = new AddressDTO();
        AddressBuilder.toDTO(shopInfo.getMainAddress(), mainAddress);
        Set<AddressDTO> addresses = new HashSet<>();

        for(Address address : shopInfo.getAddress()){
            AddressDTO addressDTO = new AddressDTO();
            AddressBuilder.toDTO(address, addressDTO);
            addresses.add(addressDTO);
        }

        shopInfoDTO.setMainAddress(mainAddress);
        shopInfoDTO.setAddress(addresses);
    }
}
