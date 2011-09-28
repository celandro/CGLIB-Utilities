package com.eharmony.lightning;

import org.joda.time.DateTime;

/*
 *  Builder pattern created with Eclipse plugin:
 *  http://code.google.com/p/bpep/
 */
public class User {
    private String firstName;
    private String lastName;
    private DateTime birthDate;
    private String address;
    private int zipCode;
    private String city;
    private String state;
    private String zipCode4;

    public User() {

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

    public DateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(DateTime birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
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

    public String getZipCode4() {
        return zipCode4;
    }

    public void setZipCode4(String zipCode4) {
        this.zipCode4 = zipCode4;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private DateTime birthDate;
        private String address;
        private int zipCode;
        private String city;
        private String state;
        private String zipCode4;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder birthDate(DateTime birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder zipCode(int zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }

        public Builder zipCode4(String zipCode4) {
            this.zipCode4 = zipCode4;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.birthDate = builder.birthDate;
        this.address = builder.address;
        this.zipCode = builder.zipCode;
        this.city = builder.city;
        this.state = builder.state;
        this.zipCode4 = builder.zipCode4;
    }
}
