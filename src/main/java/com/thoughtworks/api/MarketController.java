package com.thoughtworks.api;

import com.thoughtworks.domain.Item;
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

    @GetMapping("/market")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity getItemList(){
        List<Item> itemList = marketService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(itemList);
    }

    @PostMapping("/market/item")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity addItem(@RequestBody Item item) {
        marketService.saveItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
