package com.smartbee.jobdemo.service;

import com.smartbee.jobdemo.model.Company;
import org.springframework.data.repository.CrudRepository;


public interface CompanyRespository extends CrudRepository<Company, Integer> {
}
