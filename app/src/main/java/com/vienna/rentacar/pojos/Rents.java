package com.vienna.rentacar.pojos;


public class Rents {
    private String id, name, CustomerName, address, Contact, CarType, RentDays, DateRented, DateReturned, RentAmount, RentPaid, created_at, update_at;

    public Rents() {

    }

    public Rents(String id, String name, String customerName, String address, String contact, String carType, String rentDays, String dateRented, String dateReturned, String rentAmount, String rentPaid, String created_at, String update_at) {
        this.id = id;
        this.name = name;
        CustomerName = customerName;
        this.address = address;
        Contact = contact;
        CarType = carType;
        RentDays = rentDays;
        DateRented = dateRented;
        DateReturned = dateReturned;
        RentAmount = rentAmount;
        RentPaid = rentPaid;
        this.created_at = created_at;
        this.update_at = update_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getCarType() {
        return CarType;
    }

    public void setCarType(String carType) {
        CarType = carType;
    }

    public String getRentDays() {
        return RentDays;
    }

    public void setRentDays(String rentDays) {
        RentDays = rentDays;
    }

    public String getDateRented() {
        return DateRented;
    }

    public void setDateRented(String dateRented) {
        DateRented = dateRented;
    }

    public String getDateReturned() {
        return DateReturned;
    }

    public void setDateReturned(String dateReturned) {
        DateReturned = dateReturned;
    }

    public String getRentAmount() {
        return RentAmount;
    }

    public void setRentAmount(String rentAmount) {
        RentAmount = rentAmount;
    }

    public String getRentPaid() {
        return RentPaid;
    }

    public void setRentPaid(String rentPaid) {
        RentPaid = rentPaid;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }
}