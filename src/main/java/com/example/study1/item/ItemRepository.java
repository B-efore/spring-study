package com.example.study1.item;

import java.util.Collection;
import java.util.List;

public interface ItemRepository {
    // 물품 추가
    void save(Item item);
    // 물품 수정 (업데이트)
    void update(Item item);
    // 물품 삭제
    void delete(Long itemId);
    // 물품 하나 찾기
    Item findById(Long itemId);
    // 전체 물품 찾기
    Collection<Item> findAllItem();
}
