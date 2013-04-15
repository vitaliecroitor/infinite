package md.vcroitor.licenta.server.persistence;

import java.util.Set;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 10:03 AM
 */
public class Contact {

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
