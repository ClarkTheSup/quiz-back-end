package com.thoughtworks.service;

import org.springframework.stereotype.Service;

@Service
public class Demo {
    public Demo() {
    }

    public int add(int num1, int num2) {
        return num1 + num2;
    }
}
