package com.smartbee.jobdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartbee.jobdemo.model.Client;
import com.smartbee.jobdemo.model.Company;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class JobdemoApplicationTests {

    @Autowired
    private MockMvc mvc;

    @WithMockUser(value = "manager", roles = {"MANAGER"})
    @Test
    void testClientGetAll() throws Exception {
        mvc.perform(get("/clients"))
//                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()", Matchers.greaterThan(0)));
    }

    @WithMockUser(value = "manager", roles = {"MANAGER"})
    @Test
    void testClientFindById() throws Exception {
        int id = 1;
        mvc.perform(get(String.format("/clients/%d", id)))
//                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.is("Amber")));
    }

    @WithMockUser(value = "super_user", roles = {"SUPER_USER"})
    @Test
    void testClientCreateMutiple() throws Exception {
        String createdBy = "test";
        Date createdAt = new Date();
        mvc.perform(post("/clients/multiple")
                .content(asJsonString(List.of(
                        new Client(1, "A1", "A1@abc.com", "1234567", createdBy, createdAt),
                        new Client(1, "A2", "A1@abc.com", "1234567", createdBy, createdAt),
                        new Client(1, "A3", "A1@abc.com", "1234567", createdBy, createdAt)
                )))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
                .andExpect(status().isOk());
    }

    @WithMockUser(value = "manager", roles = {"MANAGER"})
    @Test
    void testCompanyGetAll() throws Exception {
        mvc.perform(get("/companies"))
//                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()", Matchers.greaterThan(0)));
    }

    @WithMockUser(value = "operator", roles = {"OPERATOR"})
    @Test
    void testCompanyGetAllFail() throws Exception {
        mvc.perform(get("/companies"))
//                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @WithMockUser(value = "super_user", roles = {"SUPER_USER"})
    @Test
    void testCompanyCreate() throws Exception {
        String createdBy = "test";
        Date createdAt = new Date();
        mvc.perform(post("/companies")
                .content(asJsonString(new Company("S1", "S1", createdBy, createdAt)))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
                .andExpect(status().isOk());
    }

    @WithMockUser(value = "super_user", roles = {"SUPER_USER"})
    @Test
    void testCompanyCreateMutiple() throws Exception {
        String createdBy = "test";
        Date createdAt = new Date();
        mvc.perform(post("/companies/multiple")
                .content(asJsonString(List.of(
                        new Company("A1", "A1", createdBy, createdAt),
                        new Company("A2", "A2", createdBy, createdAt),
                        new Company("A3", "A3", createdBy, createdAt)
                        )))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
