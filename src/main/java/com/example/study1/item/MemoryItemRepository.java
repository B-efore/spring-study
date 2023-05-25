package com.example.study1.item;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MemoryItemRepository implements ItemRepository {

    private static Map<Long, Item> store = new HashMap<>();

    @Override
    public void save(Item item) {
        store.put(item.getItemId(), item);
    }

    @Override
    public void update(Item item) {
        // put()과 replace()의 차이
        // 존재하지 않는 key 값을 사용할 경우 추가되지 않음 -> replace()
        store.replace(item.getItemId(), item);
    }

    @Override
    public void delete(Long itemId) {
        store.remove(itemId);
    }

    @Override
    public Item findById(Long itemId) {
        return store.get(itemId);
    }

    @Override
    public Collection<Item> findAllItem() {
        return store.values();
    }
}
