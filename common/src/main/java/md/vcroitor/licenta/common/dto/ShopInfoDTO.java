package md.vcroitor.licenta.common.dto;

import java.util.Set;

/**
 * User: Vitalie Croitor
 * Date: 4/22/13
 * Time: 2:12 PM
 */
public class ShopInfoDTO {

    private AddressDTO mainAddress;

    private Set<AddressDTO> address;

    private String url;

    private String description;

    public AddressDTO getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(AddressDTO mainAddress) {
        this.mainAddress = mainAddress;
    }

    public Set<AddressDTO> getAddress() {
        return address;
    }

    public void setAddress(Set<AddressDTO> address) {
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
}