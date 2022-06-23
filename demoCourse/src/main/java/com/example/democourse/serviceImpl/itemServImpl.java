package com.example.democourse.serviceImpl;

import com.example.democourse.Model.Item;
import com.example.democourse.dto.CreateItemDto;
import com.example.democourse.repositories.ItemRepository;
import com.example.democourse.service.IserviceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class itemServImpl implements IserviceItem {
    private final ItemRepository itemRepository;
 @Autowired
    public itemServImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @Override
    public Item create(CreateItemDto dto) {
     Item product= new Item(dto);
        return itemRepository.save(product);
    }

    @Override
    public Optional<Item> getOne(Integer id) {
        return itemRepository.findById(id);
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }
}
