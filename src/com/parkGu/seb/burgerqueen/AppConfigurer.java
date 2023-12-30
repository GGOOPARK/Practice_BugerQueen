package com.parkGu.seb.burgerqueen;

import com.parkGu.seb.burgerqueen.discount.Discount;
import com.parkGu.seb.burgerqueen.discount.discountCondition.CozDiscountCondition;
import com.parkGu.seb.burgerqueen.discount.discountCondition.DiscountCondition;
import com.parkGu.seb.burgerqueen.discount.discountCondition.KidDiscountCondition;
import com.parkGu.seb.burgerqueen.discount.discountPolicy.FixedAmountDiscountPolicy;
import com.parkGu.seb.burgerqueen.discount.discountPolicy.FixedRateDiscountPolicy;
import com.parkGu.seb.burgerqueen.product.product.ProductRepository;

public class AppConfigurer {
    private Cart cart = new Cart(productRepository(), menu());


    public ProductRepository productRepository() {
        return new ProductRepository();
    }

    public Menu menu() {
        return new Menu(productRepository().getAllProducts());
    }

    public Cart cart() {
        return cart;
    }

    public Discount discount() {
        return new Discount(
                new DiscountCondition[]{
                        new CozDiscountCondition(new FixedRateDiscountPolicy(10)),
                        new KidDiscountCondition(new FixedAmountDiscountPolicy(500))
                });
    }

    public Order order() {
        return new Order(cart(), discount());
    }
}
