package com.example.study1.order;

import com.example.study1.item.Item;

import java.util.List;

public class Order {

    private Long memberId;
    private List<Item> itemList;
    private int totalPrice;
    private int discountPrice;

    public Order(Long memberId, List<Item> itemList, int totalPrice, int discountPrice) {
        this.memberId = memberId;
        this.itemList = itemList;
        this.totalPrice = totalPrice;
        this.discountPrice = discountPrice;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }
}
