package com.example.clientdemo.dao;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Item {

    private Integer id;
    private  String name;
    private int  quantity;
    private  int price;


    //    @Transient
//    private int value;

}
