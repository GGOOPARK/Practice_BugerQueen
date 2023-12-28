package com.parkGu.seb.burgerqueen.discount.discountCondition;

import com.parkGu.seb.burgerqueen.discount.discountPolicy.FixedAmountDiscountPolicy;

import java.util.Scanner;

public class KidDiscountCondition {
    private boolean isKid;
    private FixedAmountDiscountPolicy fixedAmountDiscountPolicy = new FixedAmountDiscountPolicy(500);

    public boolean isKid() {
        return isKid;
    }

    private void setSatisfied(boolean satisfied) {
        isKid = satisfied;
    }

    public void checkDisountCondition() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("나이를 입력해주세요.");
        int input = Integer.parseInt(scanner.nextLine());

        setSatisfied(input <= 19);
    }

    public int applyDiscount(int price) {
        return fixedAmountDiscountPolicy.calculateDiscountedPrice(price);
    }
}
