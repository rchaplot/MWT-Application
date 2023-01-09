package com.smartbee.jobdemo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
public class Client implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private int companyId;
    private String name;
    private String email;
    private String phone;
    private String createdBy;
    private Date createdAt;
    private String updatedBy;
    private Date updatedAt;

    public Client(int companyId, String name, String email, String phone, String createdBy, Date createdAt) {
        this.companyId = companyId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }
}
