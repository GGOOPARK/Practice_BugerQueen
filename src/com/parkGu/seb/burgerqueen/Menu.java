package com.parkGu.seb.burgerqueen;

import com.parkGu.seb.burgerqueen.product.product.Product;
import com.parkGu.seb.burgerqueen.product.product.subproduct.Drink;
import com.parkGu.seb.burgerqueen.product.product.subproduct.Hamburger;
import com.parkGu.seb.burgerqueen.product.product.subproduct.Side;

public class Menu {
    private Product[] products;

    public Menu(Product[] products) {
        this.products = products;
    }

    public void printMenu() {
        System.out.println("메뉴");
        System.out.println("*".repeat(30));

        printHamburgers();
        printSides();
        printDrinks();

        System.out.println("(0) : 장바구니");
        System.out.println("(+) : 주문하기");
        System.out.println("메뉴를 선택해주세요 :-)");
    }

    private void printDrinks() {
        System.out.println("음료");
        for (Product product : products) {
            if (product instanceof Drink) {
                printEachMenu(product);
            }
        }
        System.out.println("-".repeat(45));
    }

    private void printSides() {
        System.out.println("사이드 메뉴");
        for (Product product : products) {
            if (product instanceof Side) {
                printEachMenu(product);
            }
        }
        System.out.println("-".repeat(45));
    }

    private void printHamburgers() {
        System.out.println("햄버거 메뉴");
        for (Product product : products) {
            if (product instanceof Hamburger) {
                printEachMenu(product);
            }
        }
        System.out.println("-".repeat(45));
    }

    private static void printEachMenu(Product product) {
        System.out.printf(
                " (%d) %s %5dkcal %5d원\n" ,
                product.getId(), product.getName(), product.getKcal(), product.getPrice()
        );
    }

}
