package com.murach.business;

import com.murach.business.Product;
import com.murach.business.Item;
import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {
    private ArrayList<Item> items;

    public Cart() {
        items = new ArrayList<Item>();
    }

    public Cart(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        String productCode = item.getProduct().getProductCode();
        for (Item i : this.getItems()) {
            if (i.getProduct().getProductCode().equals(productCode)) {
                int quantity = item.getQuantity();
                i.setQuantity(quantity);
                return;
            }
        }
        this.items.add(item);
    }
    public void removeItem(Item item) {
        String productCode = item.getProduct().getProductCode();
        items.removeIf(i -> i.getProduct().getProductCode().equals(productCode));
    }

    public int getCount() {
        return items.size();
    }
    public float getTotal() {
        float total = 0;
        for (Item i : this.getItems()) {
            total += i.getTotal();
        }
        return total;
    }
}
