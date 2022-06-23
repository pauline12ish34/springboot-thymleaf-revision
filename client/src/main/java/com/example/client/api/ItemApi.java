package com.example.client.api;


import com.example.client.model.Item;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ItemApi {

    @GetMapping
    String testFunction(Model model){


        HttpEntity entity = new HttpEntity<>(null, null);


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Item> response = restTemplate.exchange("http://localhost:8082/items/1", HttpMethod.GET, entity, Item.class);

        model.addAttribute("item", response.getBody());

        return "index";
    }

//    @GetMapping
//    String getOne(Model model) {
//        RestTemplate restTemplate= new RestTemplate();
//        HttpHeaders headers= new HttpHeaders();
//        headers.set("header","value");
//        HttpEntity<Item> requestEntity= new HttpEntity<>(null,headers);
//
//        HttpEntity<Item> itemResponse= restTemplate.exchange("http://localhost:8082/items/", HttpMethod.GET,requestEntity,Item.class);
//        model.addAttribute("item",itemResponse.getBody());
//
//       return "index";
//    }
//
//    @GetMapping
//    String getAllItems(Model model) {
//        RestTemplate restTemplate= new RestTemplate();
//
//        HttpHeaders headers= new HttpHeaders();
//        headers.set("header","value");
//
//        HttpEntity<Item> requestEntity= new HttpEntity<>(null,headers);
//
//       ResponseEntity<List> itemResponse=restTemplate.exchange("http://localhost:8082/items/all",HttpMethod.GET,requestEntity,List.class);
//List<Item> itemList= itemResponse.getBody();
//
//        model.addAttribute("items",itemList);
//
//        return "index";
//    }
//



}
