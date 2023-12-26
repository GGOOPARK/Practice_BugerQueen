package com.parkGu.seb.burgerqueen.product.product.subproduct;

import com.parkGu.seb.burgerqueen.product.product.Product;

public class Drink extends Product {
    private boolean haaStraw;

    public Drink (int id, String name, int price, int kcal, boolean hasStraw) {
        super(id, name, price, kcal);
        this.haaStraw = hasStraw;
    }

    public boolean hasStraw() {
        return haaStraw;
    }

    public void setHaaStraw(boolean haaStraw) {
        this.haaStraw = haaStraw;
    }
}
