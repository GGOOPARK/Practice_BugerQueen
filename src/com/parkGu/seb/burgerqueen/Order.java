package com.parkGu.seb.burgerqueen;

import com.parkGu.seb.burgerqueen.discount.Discount;
import com.parkGu.seb.burgerqueen.discount.discountCondition.CozDiscountCondition;
import com.parkGu.seb.burgerqueen.discount.discountCondition.DiscountCondition;
import com.parkGu.seb.burgerqueen.discount.discountCondition.KidDiscountCondition;
import com.parkGu.seb.burgerqueen.discount.discountPolicy.FixedAmountDiscountPolicy;
import com.parkGu.seb.burgerqueen.discount.discountPolicy.FixedRateDiscountPolicy;

public class Order {
    private Cart cart;
    private DiscountCondition[] discountConditions;

    private Discount discount;

    public Order(Cart cart, Discount discount) {
        this.cart = cart;
        this.discount = discount;
    }

    public void makeOrder() {
        int totalPrice = cart.calculateTotalPrice();
        int finalPrice = discount.discount(totalPrice);

        System.out.println("주문 완료");
        System.out.println("주문 내역");
        System.out.println("-".repeat(45));

        cart.printCartItemDetails();

        System.out.println("-".repeat(45));
        System.out.printf("금액합계 : %d원\n", totalPrice);
    }


}
