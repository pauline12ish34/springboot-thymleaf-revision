package com.example.clientdemo.web;

import com.example.clientdemo.dao.Item;
import com.example.clientdemo.dto.ItemDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/items")
public class ItemController {
//    String url="http://localhost:8082";
@GetMapping("/all")
    public String getItems(Model model){
        String url="http://localhost:8082/items/all";
        RestTemplate restTemplate= new RestTemplate();
        ResponseEntity<Item[]> response=restTemplate.getForEntity(url,Item[].class);
    model.addAttribute("items",response.getBody());
    return "items";
    }
    @GetMapping("/add-page")
    public String getItem(){
    return "add-item";
    }

//    @PostMapping("/create")
//    public String addStudent(String firstname,String lastname,String year,Integer age){
//        RestTemplate restTemplate=new RestTemplate();
//        StudentDto studentDto= new StudentDto(firstname,lastname,year,age);
//        String URL="http://localhost:2022/api/students";
//        restTemplate.postForEntity(URL,studentDto,Student.class);
//        return  "redirect:/students";
//    }

    @PostMapping("/create")
    public String addItem(String name,int quantity, int price){
        String url="http://localhost:8082/items";
        RestTemplate restTemplate= new RestTemplate();
        ItemDto itemDto=new ItemDto(name, quantity, price);
        restTemplate.postForEntity(url,itemDto,Item.class);
        return  "redirect:/items/all";
    }
    
}
