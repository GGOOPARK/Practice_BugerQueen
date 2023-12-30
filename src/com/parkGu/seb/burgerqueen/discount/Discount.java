package com.parkGu.seb.burgerqueen.discount;

import com.parkGu.seb.burgerqueen.discount.discountCondition.DiscountCondition;

public class Discount {
    private DiscountCondition[] discountConditions;

    public Discount(DiscountCondition[] discountConditions) {
        this.discountConditions = discountConditions;
    }

    public void checkAllDiscountConditions() {
        for (DiscountCondition discountCondition : discountConditions) {
            discountConditions.checkDiscountCondition();
        }
    }

    public int discount(int price) {
        int discountedPrice = price;

        for (DiscountCondition discountCondition : discountConditions) {
            discountConditions.checkDiscountCondition();
            if (discountCondition.isSatisfied()) discountedPrice = discountConditions.applyDiscount(discountedPrice);
        }

        return discountedPrice;
    }
}
