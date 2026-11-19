package com.murach.business;

import java.io.Serializable;
import java.text.NumberFormat;

public class Item implements Serializable{
    private int quantity;
    private Product product;

    public Item() {
        this.quantity = 0;
        this.product = new Product();
    }

    public Item(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    public float getTotal() {
        return (float) this.quantity * this.product.getPrice();
    }
    public String getTotalCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }
}
