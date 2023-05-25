package com.example.study1.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class ItemServiceImpl implements ItemService{

    private final MemoryItemRepository memoryItemRepository;

    public ItemServiceImpl(MemoryItemRepository memoryItemRepository) {
        this.memoryItemRepository = memoryItemRepository;
    }

    @Override
    public void addItem(Item item) {
        memoryItemRepository.save(item);
    }

    @Override
    public void modifyItem(Item item) {
        memoryItemRepository.update(item);
    }

    @Override
    public void removeItem(Long itemId) {
        memoryItemRepository.delete(itemId);
    }

    @Override
    public Item findItem(Long itemId) {
        return memoryItemRepository.findById(itemId);
    }

    @Override
    public Collection<Item> findAllItem() {
        return memoryItemRepository.findAllItem();
    }

    @Override
    public void printMenu(Collection<Item> items) {
        System.out.println("\n*** 구매할 메뉴의 번호를 입력해주세요 ***");
        for (Item i : items) {
            System.out.println(i.getItemId() + ". " + i.getItemName() + " " + i.getItemPrice() + "원");
        }
        System.out.println("- 구매 종료는 0번을 입력하세요.");
        System.out.print(">> ");
    }
}
