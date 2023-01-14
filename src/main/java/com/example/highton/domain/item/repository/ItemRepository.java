package com.example.highton.domain.item.repository;

import com.example.highton.domain.item.Item;
import com.example.highton.domain.item.enums.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> findAllByCategory(Category category);
    List<Item> findAllByTitleContains(String title);
}
