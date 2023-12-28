package com.parkGu.seb.burgerqueen;

import com.parkGu.seb.burgerqueen.discount.discountCondition.CozDiscountCondition;
import com.parkGu.seb.burgerqueen.discount.discountCondition.KidDiscountCondition;

public class Order {
    private Cart cart;

    public Order(Cart cart) {
        this.cart = cart;
    }

    public void makeOrder() {
        CozDiscountCondition cozDiscountCondition = new CozDiscountCondition();
        KidDiscountCondition kidDiscountCondition = new KidDiscountCondition();

        cozDiscountCondition.checkDiscountCondition();
        kidDiscountCondition.checkDisountCondition();

        int totalPrice = cart.calculateTotalPrice();
        int finalPrice = totalPrice;

        if (cozDiscountCondition.isCoz()) finalPrice = cozDiscountCondition.applyDiscount(finalPrice);
        if (kidDiscountCondition.isKid()) finalPrice = cozDiscountCondition.applyDiscount(finalPrice);

        System.out.println("주문 완료");
        System.out.println("주문 내역");
        System.out.println("-".repeat(45));

        cart.printCartItemDetails();

        System.out.println("-".repeat(45));
        System.out.printf("금액합계 : %d원\n", totalPrice);
    }


}
