package com.parkGu.seb.burgerqueen.discount.discountPolicy;

public interface DiscountPolicy {
    int calculateDiscountedPrice(int price);
}

public class FixedRateDiscountPolicy implements DiscountPolicy {


}

public class FixedAmountDiscountPolicy implements DiscountPolicy {

}

