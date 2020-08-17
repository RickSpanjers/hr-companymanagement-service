package nl.hrmanagement.companymanagement.model;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {

    private int id;
    private UUID uuid;
    private String mail;
    private String password;
    private String firstName;
    private String lastName;
    private String telephone;
    private String address;
    private String country;
    private String zipcode;
    private String place;
    private UUID functionId;
    private UUID companyId;
    private boolean archived;


    private Role role;

    public User(){
    }

    public User(int id, UUID uuid, String firstName, String lastName, UUID companyId, UUID functionId){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.uuid = uuid;
        this.companyId = companyId;
        this.functionId = functionId;
    }

    public User(String mail, String password, String firstName, String lastName, String telephone, String address, String country, String zipcode, String place, UUID functionId, UUID companyId, Role role) {
        this.mail = mail;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.address = address;
        this.country = country;
        this.zipcode = zipcode;
        this.place = place;
        this.functionId = functionId;
        this.companyId = companyId;
        this.role = role;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public UUID getFunctionId() {
        return functionId;
    }

    public UUID getCompanyId() {
        return companyId;
    }

    public UUID getUuid() {
        return uuid;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }

    public void setFunctionId(UUID functionId) {
        this.functionId = functionId;
    }
}
