package com.paypal.bfs.test.employeeserv.persistence.entity;


import javax.persistence.*;
import java.util.StringJoiner;

@Entity(name = "Address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String country;
    @Column(name = "zip_code")
    private String zipCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AddressEntity.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("line1='" + line1 + "'")
                .add("line2='" + line2 + "'")
                .add("city='" + city + "'")
                .add("state='" + state + "'")
                .add("country='" + country + "'")
                .add("zipCode='" + zipCode + "'")
                .toString();
    }
}
