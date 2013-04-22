package md.vcroitor.licenta.common.dto;

/**
 * User: Vitalie Croitor
 * Date: 4/22/13
 * Time: 2:17 PM
 */
public class AddressDTO {

    private String country;

    private int zip;

    private String city;

    private String street;

    private ContactDTO contact;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public ContactDTO getContact() {
        return contact;
    }

    public void setContact(ContactDTO contact) {
        this.contact = contact;
    }
}