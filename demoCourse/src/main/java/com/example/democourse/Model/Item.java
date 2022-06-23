package com.example.democourse.Model;

import com.example.democourse.dto.CreateItemDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    private  String name;
    private int  quantity;
    private  int price;

    public Item(CreateItemDto dto) {
        this.name = dto.getName();
        this.quantity = dto.getQuantity();
        this.price = dto.getPrice();
    }
    //    @Transient
//    private int value;

}
