package com.parkGu.seb.burgerqueen.discount.discountCondition;

public interface DiscountCondition {
    void checkDiscountCondition();
    int applyDiscount(int price);
    boolean isSatisfied();
}