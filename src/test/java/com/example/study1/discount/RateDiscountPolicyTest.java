package com.example.study1.discount;

import com.example.study1.member.Grade;
import com.example.study1.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    void discount_gold(){
        Member member = new Member(1L, "010-0000-0000", Grade.GOLD);

        int discount = rateDiscountPolicy.discount(member, 20000);
        assertThat(discount).isEqualTo(2000);
    }

    @Test
    void discount_silver(){
        Member member = new Member(2L, "010-0000-0000", Grade.SILVER);

        int discount = rateDiscountPolicy.discount(member, 40000);
        assertThat(discount).isEqualTo(2000);
    }

    @Test
    void discount_basic(){
        Member member = new Member(3L, "010-0000-0000", Grade.BASIC);

        int discount = rateDiscountPolicy.discount(member, 4000);
        assertThat(discount).isEqualTo(0);
    }
}
