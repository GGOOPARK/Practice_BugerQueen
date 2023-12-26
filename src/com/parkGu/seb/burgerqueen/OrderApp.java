package com.parkGu.seb.burgerqueen;

import com.parkGu.seb.burgerqueen.product.product.Product;
import com.parkGu.seb.burgerqueen.product.product.ProductRepository;

public class OrderApp {
    public void start() {
        ProductRepository productRepository = new ProductRepository();
        Product[] products = productRepository.getAllProducts();
        Menu menu = new Menu(products);

        System.out.println("BurgerQueen Order Service");

        while (true) {
            menu.printMenu();

        }
    }
}
