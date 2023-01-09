package com.smartbee.jobdemo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@AutoConfigureMockMvc
public class HomeControllerTest {
//    @Autowired
//    private MockMvc mvc;
//
//    @WithMockUser(value = "manager", roles = {"MANAGER"})
//    @Test
//    void testHome() throws Exception {
//        mvc.perform(get("/")).andExpect(status().isOk());
//    }
//
//    @WithMockUser(value = "manager", roles = {"MANAGER"})
//    @Test
//    void testHello() throws Exception {
//        mvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk()).andExpect(
//                content().string(containsString("Hello World!")));
//    }
}
