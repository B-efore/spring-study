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

    @Override
    public void printOrder(Order order) {
        System.out.println("\n*** 사용자 주문 내역 ***");
        for (Item i : order.getItemList()) {
            System.out.println(i.getItemName() + " " + i.getItemPrice() + "원");
        }
        int totalPrice = order.getTotalPrice();
        int discountPrice = order.getDiscountPrice();
        int result = totalPrice - discountPrice;
        System.out.println("***");
        System.out.println("전체 금액 : " + totalPrice);
        System.out.println("할인 금액 : " + discountPrice);
        System.out.println("***");
        System.out.println("최종 금액 : " + result);
    }
}
