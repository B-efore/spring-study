package com.example.study1.discount;

import com.example.study1.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    @Override
    public int discount(Member member, int price) {
        return 0;
    }
}
