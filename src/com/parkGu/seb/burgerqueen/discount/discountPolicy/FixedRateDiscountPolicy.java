package com.parkGu.seb.burgerqueen.discount.discountPolicy;

public class FixedRateDiscountPolicy {
    private int discountRate;

    public FixedRateDiscountPolicy(int discountRate) {
        this.discountRate = discountRate;
    }

    public int calculateDiscountPrice(int price) {
        return price - (price * discountRate / 100);
    }
}
