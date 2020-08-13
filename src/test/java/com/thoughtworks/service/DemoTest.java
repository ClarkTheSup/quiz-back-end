package com.thoughtworks.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoTest {
    @Autowired
    Demo demo;

    @Test
    public void addTest() {
        assertEquals(2, demo.add(1, 1));
    }
}