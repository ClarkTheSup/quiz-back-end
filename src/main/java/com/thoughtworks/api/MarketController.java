package com.thoughtworks.api;

import com.thoughtworks.domain.Item;
import com.thoughtworks.dto.ItemDto;
import com.thoughtworks.repository.ItemRepository;
import com.thoughtworks.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MarketController {
    @Autowired
    MarketService marketService;

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/market")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity getItemList(){
        //List<Item> itemList = marketService.findAll();
        List<ItemDto> itemDtoList = itemRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(itemDtoList);
    }

    @PostMapping("/market/item")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity addItem(@RequestBody ItemDto itemDto) {
        //marketService.saveItem(item);
        itemRepository.save(itemDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
