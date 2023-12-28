package com.parkGu.seb.burgerqueen.discount.discountCondition;

import com.parkGu.seb.burgerqueen.discount.discountPolicy.FixedRateDiscountPolicy;

import java.util.Scanner;

public class CozDiscountCondition {
    private FixedRateDiscountPolicy fixedRateDiscountPolicy = new FixedRateDiscountPolicy(10);
    public int applyDiscount(int price) {
        return fixedRateDiscountPolicy.calculateDiscountPrice(price);
    }
    public boolean isCoz;

    public boolean isCoz() {
        return isCoz;
    }

    public void setSatisfied(boolean satisfied) {
        isCoz = satisfied;
    }

    public void checkDiscountCondition() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("강의 수강생이십니까? (1)예 (2)아니오");
        String input = scanner.nextLine();

        if (input.equals("1")) setSatisfied(true);
        else if (input.equals("2")) setSatisfied(false);
    }
}