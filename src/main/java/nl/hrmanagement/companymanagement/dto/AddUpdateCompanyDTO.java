package nl.hrmanagement.companymanagement.dto;

import nl.hrmanagement.companymanagement.model.Function;

import java.util.List;
import java.util.UUID;

public class AddUpdateCompanyDTO {
    private UUID companyId;
    private String name;
    private String taxId;
    private int registrationNumber;
    private String phone;
    private String mail;
    private String addressOne;
    private String addressTwo;
    private String city;
    private String zipcode;
    private String country;
    private boolean archived;
    private String ceo;

    public AddUpdateCompanyDTO() {
    }

    public AddUpdateCompanyDTO(UUID companyId, String name, String taxId, int registrationNumber, String phone, String mail, String addressOne, String addressTwo, String city, String zipcode, String country, boolean archived, String ceo) {
        this.companyId = companyId;
        this.name = name;
        this.taxId = taxId;
        this.registrationNumber = registrationNumber;
        this.phone = phone;
        this.mail = mail;
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
        this.archived = archived;
        this.ceo = ceo;
    }

    public boolean isArchived() {
        return archived;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddressOne() {
        return addressOne;
    }

    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    public String getAddressTwo() {
        return addressTwo;
    }

    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public UUID getCompanyId() {
        return companyId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }

    public boolean getArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }
}
