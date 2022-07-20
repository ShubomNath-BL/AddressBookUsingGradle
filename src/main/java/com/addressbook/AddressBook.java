package com.addressbook;

public class AddressBook {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zip;
    private long phoneNumber;
    private String email;

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getAddress() {
        return address;
    }
    public String getCity() {
        return city;
    }
    public String getEmail() {
        return email;
    }
    public int getZip() {
        return zip;
    }
    public String getState() {
        return state;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setZip(int zip) {
        this.zip = zip;
    }
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Contacts { " +
                "firstName ='" + firstName + '\'' +
                ", lastName ='" + lastName + '\'' +
                ", address ='" + address + '\'' +
                ", city ='" + city + '\'' +
                ", state ='" + state + '\'' +
                ", zip =" + zip +
                ", PhoneNumber =" + phoneNumber +
                ", email ='" + email + '\'' +
                '}';
    }
}
