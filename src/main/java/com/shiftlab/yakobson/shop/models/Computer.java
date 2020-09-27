package com.shiftlab.yakobson.shop.models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Computer implements Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private double price;
    private long serialNumber;
    private String manufacturer;
    private long unitsInStock;

    private int computerType;




    public Computer(Long id, String productName, double price, long serialNumber, String manufacturer, long unitsInStock, int computerType) {
        this.id= id;
        this.productName = productName;
        this.price = price;
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.unitsInStock = unitsInStock;

        this.computerType = computerType;
    }

    public Computer() {
        this.productName = "";
        this.price = 0;
        this.serialNumber = 0;
        this.manufacturer = "";
        this.unitsInStock = 0;
        this.computerType = 0;
    }

    public int getComputerType() {
        return computerType;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public long getSerialNumber() {
        return serialNumber;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public long getUnitsInStock() {
        return unitsInStock;
    }
}
