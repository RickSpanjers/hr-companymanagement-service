package nl.hrmanagement.companymanagement.model;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Cacheable
@Table(name = "company")
@org.hibernate.annotations.Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uuid", columnDefinition = "BINARY(16)")
    private UUID uuid;


    @Column(name = "name")
    private String name;
    @Column(name="ceo")
    private String ceo;
    @Column(name = "taxId")
    private String taxId;
    @Column(name = "registrationNumber")
    private int registrationNumber;
    @Column(name = "phone")
    private String phone;
    @Column(name = "mail")
    private String mail;
    @Column(name = "addressOne")
    private String addressOne;
    @Column(name = "addressTwo")
    private String addressTwo;
    @Column(name = "city")
    private String city;
    @Column(name = "zipcode")
    private String zipcode;
    @Column(name = "country")
    private String country;

    @Column(name = "archived")
    private boolean archived;

    public Company(){

    }

    public Company(int id, UUID uuid){
        this.id = id;
        this.uuid = uuid;
    }

    public Company(String name, String ceo, String taxId, int registrationNumber, String phone, String mail, String addressOne, String addressTwo, String city, String zipcode, String country, boolean archived) {
        this.name = name;
        this.ceo = ceo;
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
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
