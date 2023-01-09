package com.smartbee.jobdemo.controller;

import com.smartbee.jobdemo.model.BaseRestResp;
import com.smartbee.jobdemo.model.Client;
import com.smartbee.jobdemo.model.Company;
import com.smartbee.jobdemo.service.ClientRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@Slf4j
public class ClientController {

    @Autowired
    private ClientRespository clientRespository;

    @GetMapping("/clients")
    public List<Client> getAll() {
        log.info("getAll...");
        List<Client> result = new ArrayList<>();
        clientRespository.findAll().forEach(result::add);
        return result;
//        try {
//            return new BaseRestResp<>(200, "success", result);
//        } catch (Exception e) {
//            return new BaseRestResp<>(400, e.getMessage(), null);
//        }
    }

    @GetMapping("/clients/{id}")
    public Client findById(@PathVariable int id) {
        log.info("findById:{}", id);
        return clientRespository.findById(id).orElseThrow(() -> new DataNotFoundException(String.format("client[%d] not found", id)));
//        Optional<Client> client = clientRespository.findById(id);
//        try {
//            return new BaseRestResp<Client>(200, "success", client.get());
//        } catch (Exception e) {
//            return new BaseRestResp<Client>(400, String.format("client[%d] not found", id), null);
//        }
    }

    @RolesAllowed({"SUPER_USER", "OPERATOR"})
    @PostMapping(value = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
    public Client create(@RequestBody Client client) {
        log.info("create:{}", client);
        return clientRespository.save(client);
    }

    @RolesAllowed({"SUPER_USER", "MANAGER"})
    @PutMapping(value = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
    public Client update(@RequestBody Client client) {
        log.info("update:{}", client);
        return clientRespository.save(client);
    }

    @RolesAllowed({"SUPER_USER", "MANAGER"})
    @DeleteMapping(value = "/clients/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@PathVariable int id) {
        log.info("delete id:{}", id);
        clientRespository.deleteById(id);
        return "OK";
    }

    @RolesAllowed({"SUPER_USER", "OPERATOR"})
    @PostMapping(value = "/clients/multiple", produces = MediaType.APPLICATION_JSON_VALUE)
    public String createMutiple(@RequestBody List<Client> clients) {
        log.info("createMutiple:{}", clients);
        clientRespository.saveAll(clients);
        return "OK";
    }
}
