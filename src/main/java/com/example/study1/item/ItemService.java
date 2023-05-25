package com.example.study1.item;

import java.util.Collection;
import java.util.List;

public interface ItemService {
    // 아이템 추가
    void addItem(Item item);
    // 아이템 수정
    void modifyItem(Item item);
    // 아이템 삭제
    void removeItem(Long itemId);
    // 아이템 조회
    Item findItem(Long itemId);
    // 전체 아이템 조회
    Collection<Item> findAllItem();
    // 메뉴 출력
    void printMenu(Collection<Item> items);
}
