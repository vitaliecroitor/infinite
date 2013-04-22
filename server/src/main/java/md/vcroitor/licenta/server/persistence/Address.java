package md.vcroitor.licenta.server.persistence;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 10:01 AM
 */
public class Address {

    private String country;

    private int zip;

    private String city;

    private String street;

    private Contact contact;

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

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}