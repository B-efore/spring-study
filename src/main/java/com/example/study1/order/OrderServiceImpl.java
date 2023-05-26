package com.example.study1.order;

import com.example.study1.discount.DiscountPolicy;
import com.example.study1.item.Item;
import com.example.study1.member.Member;
import com.example.study1.member.MemberRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, List<Item> itemList) {

        int totalPrice = 0;
        for(Item i : itemList) {
            totalPrice += i.getItemPrice();
        }

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, totalPrice);

        return new Order(memberId, itemList, totalPrice, discountPrice);
    }
}
