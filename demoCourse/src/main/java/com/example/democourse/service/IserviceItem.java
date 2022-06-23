package com.example.democourse.service;

import com.example.democourse.Model.Item;
import com.example.democourse.dto.CreateItemDto;

import java.util.List;
import java.util.Optional;

public interface IserviceItem {
    Item create(CreateItemDto dto);
    Optional<Item> getOne(Integer id);
    List<Item> getAll();
}
