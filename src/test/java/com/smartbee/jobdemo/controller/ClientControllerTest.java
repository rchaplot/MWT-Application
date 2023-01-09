package com.smartbee.jobdemo.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//@AutoConfigureMockMvc
public class ClientControllerTest {

//    @Autowired
//    private MockMvc mvc;
//
//    @WithMockUser(value = "manager", roles = {"MANAGER"})
//    @Test
//    void getAll() throws Exception {
//        mvc.perform(get("/clients")).andDo(print()).andExpect(status().isOk());
//    }
//
//    @WithMockUser(value = "manager", roles = {"MANAGER"})
//    @Test
//    void findById() throws Exception {
//        int id = 1;
//        mvc.perform(get(String.format("/clients/%d", id))).andDo(print()).andExpect(status().isOk());
//    }

//    @WithMockUser(value = "manager", roles = {"MANAGER"})
//    @Test
//    void create() {
//    }

//    @WithMockUser(value = "manager", roles = {"MANAGER"})
//    @Test
//    void update() {
//    }

//    @WithMockUser(value = "manager", roles = {"MANAGER"})
//    @Test
//    void delete() {
//    }
}