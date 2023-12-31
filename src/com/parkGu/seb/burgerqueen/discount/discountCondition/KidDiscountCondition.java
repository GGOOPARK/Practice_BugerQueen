package com.parkGu.seb.burgerqueen.discount.discountCondition;

import com.parkGu.seb.burgerqueen.discount.discountPolicy.DiscountPolicy;

import java.util.Scanner;

public class KidDiscountCondition implements DiscountCondition {
    private boolean isSatisfied;
    private DiscountPolicy discountPolicy;

    public KidDiscountCondition(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public boolean isSatisfied() {
        return isSatisfied;
    }

    private void setSatisfied(boolean satisfied) {
        isSatisfied = satisfied;
    }

    public void checkDiscountCondition() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("나이를 입력해주세요.");
        int input = Integer.parseInt(scanner.nextLine());

        setSatisfied(input <= 19);
    }

    public int applyDiscount(int price) {
        return discountPolicy.calculateDiscountedPrice(price);
    }
}
