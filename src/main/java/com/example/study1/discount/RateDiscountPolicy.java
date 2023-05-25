package com.example.study1.discount;

import com.example.study1.member.Grade;
import com.example.study1.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private final int GOLD_DISCOUNT_PERCENT = 10;
    private final int SILVER_DISCOUNT_PERCENT = 5;


    @Override
    public int discount(Member member, int price) {
        switch(member.getGrade()) {
            case GOLD -> {
                return price * GOLD_DISCOUNT_PERCENT / 100;
            }
            case SILVER -> {
                return price * SILVER_DISCOUNT_PERCENT / 100;
            }
            default -> {
                return 0;
            }
        }
    }
}
