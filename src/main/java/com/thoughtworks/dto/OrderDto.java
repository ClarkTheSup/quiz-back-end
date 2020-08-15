package com.thoughtworks.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="order_dto")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    @Id
    @GeneratedValue
    private int id;

    private String order_name;
    private String order_time;
    private int item_id;

    //@OneToMany(mappedBy = "order_dto")
    //private List<ItemDto> item_dto_list;
}
