package com.thoughtworks.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    //@Autowired
    //Demo demo;

    @GetMapping("/")
    public ResponseEntity addition(){
        //int a = demo.add(1, 1);
        return ResponseEntity.status(HttpStatus.OK).body(2);
    }
}
