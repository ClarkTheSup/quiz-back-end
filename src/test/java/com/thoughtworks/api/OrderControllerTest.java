package com.thoughtworks.api;

import com.thoughtworks.dto.ItemDto;
import com.thoughtworks.dto.OrderDto;
import com.thoughtworks.repository.OrderRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    OrderRepository orderRepository;

    @Test
    @Order(1)
    void when_perform_get_order_then_return_all_order() throws Exception {
        mockMvc.perform(get("/order"))
                .andExpect(jsonPath("$", hasSize(0)))
                .andExpect(status().isOk());
    }

    @Test
    @Order(2)
    void when_perform_delete_order_then_delete_all() throws Exception {
        mockMvc.perform(post("/orderDelete"))
                .andExpect(jsonPath("$", hasSize(0)))
                .andExpect(status().isCreated());
    }

    @Test
    @Order(3)
    void given_id_then_delete_order() throws Exception {
        mockMvc.perform(post("/orderDelete/1}"))
               .andExpect(jsonPath("$", hasSize(0))).andExpect(status().isCreated());
    }
}
