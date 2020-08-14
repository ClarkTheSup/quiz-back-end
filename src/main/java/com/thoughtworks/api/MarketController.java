package com.thoughtworks.api;

import com.thoughtworks.domain.Item;
import com.thoughtworks.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MarketController {
    @Autowired
    MarketService marketService;

    @GetMapping("/market")
    public ResponseEntity addition(){
        List<Item> itemList = marketService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(itemList);
    }
}
