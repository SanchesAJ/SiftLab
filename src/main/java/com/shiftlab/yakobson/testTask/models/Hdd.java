package com.shiftlab.yakobson.testTask.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hdd implements Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;

    private Double price;
    private Long serialNumber;
    private String manufacturer;
    private Long unitsInStock;

    private Long volume;

    public Hdd() {

    }


    public void editHdd(String productName, double price, long serialNumber, String manufacturer, long unitsInStock, long volume){
        this.productName = productName;
        this.price = price;
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.unitsInStock = unitsInStock;
        this.volume = volume;
    }


    public Hdd(Long volume,String productName, double price, long serialNumber, String manufacturer, long unitsInStock) {
        this.volume = volume;
        this.productName = productName;
        this.price = price;
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.unitsInStock = unitsInStock;
    }


    public Long getVolume() {
        return volume;
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
