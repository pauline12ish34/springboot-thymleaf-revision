package com.example.democourse.controller;

import com.example.democourse.Model.Item;
import com.example.democourse.dto.CreateItemDto;
import com.example.democourse.service.IserviceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final IserviceItem itemService;

    @Autowired
    public ItemController(IserviceItem itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/all")
    public List<Item> getAll(){
        return  itemService.getAll();
    }
    @PostMapping
    Item create(@RequestBody CreateItemDto dto){
        return itemService.create(dto);
    }
    @GetMapping("/{id}")
    Item getOne(@PathVariable int id){
        if(itemService.getOne(id).isPresent()){
            return  itemService.getOne(id).get();
        }
        return null;
    }


}
