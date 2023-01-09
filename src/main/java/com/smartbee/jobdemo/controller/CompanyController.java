package com.smartbee.jobdemo.controller;

import com.smartbee.jobdemo.model.Company;
import com.smartbee.jobdemo.service.CompanyRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;


@RestController
@Slf4j
public class CompanyController {

    @Autowired
    private CompanyRespository companyRespository;

    @RolesAllowed({"SUPER_USER", "MANAGER"})
    @GetMapping("/companies")
    public List<Company> getAll() {
        log.info("getAll...");
        List<Company> result = new ArrayList<>();
        companyRespository.findAll().forEach(result::add);
        return result;
    }

    @GetMapping("/companies/{id}")
    public Company findById(@PathVariable int id) {
        log.info("findById:{}", id);
        return companyRespository.findById(id).orElseThrow(() -> new DataNotFoundException(String.format("company[%d] not found", id)));
    }

    @RolesAllowed({"SUPER_USER", "OPERATOR"})
    @PostMapping(value = "/companies", produces = MediaType.APPLICATION_JSON_VALUE)
    public Company create(@RequestBody Company company) {
        log.info("create:{}", company);
        return companyRespository.save(company);
    }

    @RolesAllowed({"SUPER_USER", "MANAGER"})
    @PutMapping(value = "/companies", produces = MediaType.APPLICATION_JSON_VALUE)
    public Company update(@RequestBody Company company) {
        log.info("update:{}", company);
        return companyRespository.save(company);
    }

    @RolesAllowed({"SUPER_USER", "MANAGER"})
    @DeleteMapping(value = "/companies/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@PathVariable int id) {
        log.info("delete id:{}", id);
        companyRespository.deleteById(id);
        return "OK";
    }

    @RolesAllowed({"SUPER_USER", "OPERATOR"})
    @PostMapping(value = "/companies/multiple", produces = MediaType.APPLICATION_JSON_VALUE)
    public String createMutiple(@RequestBody List<Company> companies) {
        log.info("createMutiple:{}", companies);
        companyRespository.saveAll(companies);
        return "OK";
    }
}
