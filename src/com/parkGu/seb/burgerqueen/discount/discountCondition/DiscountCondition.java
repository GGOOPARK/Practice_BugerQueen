package com.parkGu.seb.burgerqueen.discount.discountCondition;

public interface DiscountCondition {
    void checkDiscountCondition();
    int applyDiscount(int price);
    boolean isSatisfied();
}

public class CozDiscountCondition implements DiscountCondition {

}

public class KidDiscountCondition implements DiscountCondition {

}
