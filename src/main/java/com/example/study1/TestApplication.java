package com.example.study1;

import com.example.study1.item.Item;
import com.example.study1.item.ItemService;
import com.example.study1.member.Grade;
import com.example.study1.member.Member;
import com.example.study1.member.MemberService;
import com.example.study1.order.Order;
import com.example.study1.order.OrderService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.*;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {

        ApplicationContext ac = new AnnotationConfigApplicationContext(TestApplication.class);

        // 더미 데이터
        MemberService memberService = ac.getBean(MemberService.class);
        Member member = new Member(1L, "010-0000-0000", Grade.SILVER);
        memberService.join(member);

        ItemService itemService = ac.getBean(ItemService.class);
        itemService.addItem(new Item(1L, "아메리카노", 3000));
        itemService.addItem(new Item(2L, "카페라떼", 4000));
        itemService.addItem(new Item(3L, "바닐라라떼", 4500));
        itemService.addItem(new Item(4L, "아이스티", 3500));

        Collection<Item> allItem = itemService.findAllItem();
        List<Item> orderItems = new ArrayList<>();

        while (true) {
            // 메뉴판 출력
            itemService.printMenu(allItem);

            try {
                Scanner scanner = new Scanner(System.in);
                Long check = scanner.nextLong();

                if(check == 0) {
                    break;
                }
                else if(check>=0 && check<=allItem.size()){
                    orderItems.add(itemService.findItem(check));
                }
                else{
                    System.out.println("[Error] 주어진 범위 내에서 입력해주세요.");
                }
            } catch (InputMismatchException e){
                System.out.println("[Error] 잘못된 입력입니다. 정수를 입력해주세요.");
            }
        }

        if(orderItems.size()==0){
            System.out.println("주문을 취소합니다. 안녕히가세요.");
        }
        else{
            OrderService orderService = ac.getBean(OrderService.class);
            Order order = orderService.createOrder(member.getId(), orderItems);

            orderService.printOrder(order);
        }

    }
}
