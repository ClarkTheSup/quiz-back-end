package com.thoughtworks.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="item")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDto {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double price;
    private String measurement;
    private String image_url;
}
