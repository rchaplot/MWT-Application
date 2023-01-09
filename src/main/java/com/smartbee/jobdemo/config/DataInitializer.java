package com.smartbee.jobdemo.config;

import com.smartbee.jobdemo.model.Client;
import com.smartbee.jobdemo.model.Company;
import com.smartbee.jobdemo.service.ClientRespository;
import com.smartbee.jobdemo.service.CompanyRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.stream.Stream;


@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private CompanyRespository companyRespository;
    private ClientRespository clientRespository;

    public DataInitializer(CompanyRespository companyRespository,
            ClientRespository clientRespository) {
        this.companyRespository = companyRespository;
        this.clientRespository = clientRespository;
    }

    @Override
    public void run(String... args) {
        log.info("start DataInitializer...");
        String createdBy = "prins";
        Date createdAt = new Date();
        Stream.of("TSMC", "Foxconn", "MediaTek").forEach(name ->
                companyRespository.save(new Company(name, "abcdefg", createdBy, createdAt)));

        int[] companyId = {1};
        Stream.of("Amber", "Bob", "Chris").forEach(name ->
                clientRespository.save(
                        new Client(companyId[0]++, name, name + "@abc.com", "12345678", createdBy, createdAt)));
        log.info("end DataInitializer...");
    }
}
