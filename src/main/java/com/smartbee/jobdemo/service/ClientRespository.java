package com.smartbee.jobdemo.service;

import com.smartbee.jobdemo.model.Client;
import com.smartbee.jobdemo.model.Company;
import org.springframework.data.repository.CrudRepository;


public interface ClientRespository extends CrudRepository<Client, Integer> {
}
