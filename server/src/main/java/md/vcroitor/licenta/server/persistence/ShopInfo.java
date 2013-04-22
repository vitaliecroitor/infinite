package md.vcroitor.licenta.server.persistence;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Set;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 10:03 AM
 */
public class ShopInfo {

    private Address mainAddress;

    private Set<Address> address;

    private String url;

    private String description;

    public Address getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(Address mainAddress) {
        this.mainAddress = mainAddress;
    }

    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}