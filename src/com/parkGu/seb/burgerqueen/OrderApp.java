package com.parkGu.seb.burgerqueen;

import com.parkGu.seb.burgerqueen.discount.Discount;
import com.parkGu.seb.burgerqueen.discount.discountCondition.CozDiscountCondition;
import com.parkGu.seb.burgerqueen.discount.discountCondition.DiscountCondition;
import com.parkGu.seb.burgerqueen.discount.discountCondition.KidDiscountCondition;
import com.parkGu.seb.burgerqueen.discount.discountPolicy.FixedAmountDiscountPolicy;
import com.parkGu.seb.burgerqueen.discount.discountPolicy.FixedRateDiscountPolicy;
import com.parkGu.seb.burgerqueen.product.product.Product;
import com.parkGu.seb.burgerqueen.product.product.ProductRepository;

import java.util.Scanner;

public class OrderApp {
    private ProductRepository productRepository;
    private Menu menu;
    private Cart cart;
    private Order order;

    public OrderApp(ProductRepository productRepository, Menu menu, Cart cart, Order order) {
        this.productRepository = productRepository;
        this.menu = menu;
        this.cart = cart;
        this.order = order;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("BurgerQueen Order Service");

        while (true) {
            menu.printMenu();
            String input = scanner.nextLine();

            if (input.equals("+")) {
                order.makeOrder();
                break;
            } else {
                int menuNumber = Integer.parseInt(input);

                if (menuNumber == 0) cart.printCart();
                else if (1 <= menuNumber && menuNumber <= productRepository.getAllProducts().length) {
                    cart.addToCart(menuNumber);
                }
            }
        }
    }
}
