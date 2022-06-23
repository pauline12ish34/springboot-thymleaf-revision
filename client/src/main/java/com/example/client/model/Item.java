package com.example.client.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
    private Integer id;
    private  String name;
    private int  quantity;
    private  int price;
}
