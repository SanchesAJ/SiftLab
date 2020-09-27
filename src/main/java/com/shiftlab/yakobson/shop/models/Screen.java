package com.shiftlab.yakobson.shop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Screen implements Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;

    private Double price;
    private Long serialNumber;
    private String manufacturer;
    private Long unitsInStock;

    private int diagonal;

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
