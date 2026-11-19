package com.murach.business;

import java.io.Serializable;
import java.text.NumberFormat;

public class Product implements Serializable {
    private String productCode;
    private String description;
    private float price;

    public Product() {
        this.productCode = "";
        this.description = "";
        this.price = 0;
    }

    public Product(String productCode, String description, float price) {
        this.productCode = productCode;
        this.description = description;
        this.price = price;
    }

    public String getProductCode() {
        return this.productCode;
    }
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public float getPrice() {
        return this.price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public String getPriceCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }
}
