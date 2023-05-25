package com.example.study1.discount;

import com.example.study1.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
