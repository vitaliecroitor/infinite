package md.vcroitor.licenta.server.builder;

import md.vcroitor.licenta.common.dto.AddressDTO;
import md.vcroitor.licenta.common.dto.ContactDTO;
import md.vcroitor.licenta.server.persistence.Address;

import static org.springframework.beans.BeanUtils.copyProperties;

/**
 * User: Vitalie Croitor
 * Date: 4/23/13
 * Time: 12:21 PM
 */
public class AddressBuilder {

    public static void toDTO(final Address address, final AddressDTO addressDTO) {
        copyProperties(address, addressDTO, new String[]{"contact"});

        ContactDTO contactDTO = new ContactDTO();
        ContactBuilder.toDTO(address.getContact(), contactDTO);
        addressDTO.setContact(contactDTO);
    }
}
