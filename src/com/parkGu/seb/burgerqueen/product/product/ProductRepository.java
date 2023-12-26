package com.parkGu.seb.burgerqueen.product.product;

import com.parkGu.seb.burgerqueen.product.product.Product;
import com.parkGu.seb.burgerqueen.product.product.subproduct.Drink;
import com.parkGu.seb.burgerqueen.product.product.subproduct.Hamburger;
import com.parkGu.seb.burgerqueen.product.product.subproduct.Side;

public class ProductRepository {
    private final Product[] products = {
            new Hamburger(1, "불고기버거", 4500, 440, false, 6800),
            new Hamburger(2, "더블불고기버거", 6000, 650, false, 8300),
            new Side(3, "감자튀김", 1500, 300, 1),
            new Side(4, "치즈스틱", 1200, 180, 0),
            new Drink(5, "펩시", 1500, 120, true),
            new Drink(6, "펩시제로", 1500, 0, true)
    };

    public Product[] getAllProducts() {
        return products;
    }

    public Product findById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) return product;
        }
        return null;
    }
}
