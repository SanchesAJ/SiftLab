package com.shiftlab.yakobson.shop.models;

public interface Product {
    Long getId();
    String getProductName();

    double getPrice();
    long getSerialNumber();
    String getManufacturer();
    long getUnitsInStock();


}
