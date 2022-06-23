package com.example.democourse.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateItemDto {
    private  String name;
    private int  quantity;
    private  int price;

}
