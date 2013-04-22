package md.vcroitor.licenta.common.dto;

import java.util.Set;

/**
 * User: Vitalie Croitor
 * Date: 4/22/13
 * Time: 2:18 PM
 */
public class ContactDTO {

    private Set<String> phone;

    private Set<String> email;

    private Set<String> fax;

    public Set<String> getPhone() {
        return phone;
    }

    public void setPhone(Set<String> phone) {
        this.phone = phone;
    }

    public Set<String> getEmail() {
        return email;
    }

    public void setEmail(Set<String> email) {
        this.email = email;
    }

    public Set<String> getFax() {
        return fax;
    }

    public void setFax(Set<String> fax) {
        this.fax = fax;
    }
}