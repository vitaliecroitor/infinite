package md.vcroitor.licenta.server.builder;

import md.vcroitor.licenta.common.dto.ContactDTO;
import md.vcroitor.licenta.server.persistence.Contact;

import static org.springframework.beans.BeanUtils.copyProperties;

/**
 * User: Vitalie Croitor
 * Date: 4/23/13
 * Time: 12:22 PM
 */
public class ContactBuilder {
    public static void toDTO(final Contact contact, final ContactDTO contactDTO) {
        copyProperties(contact, contactDTO);
    }
}
