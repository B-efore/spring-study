package com.example.study1.order;

import com.example.study1.item.Item;

import java.util.List;

public interface OrderService {
    Order createOrder(Long memberId, List<Item> itemList);

    void printOrder(Order order);
}
