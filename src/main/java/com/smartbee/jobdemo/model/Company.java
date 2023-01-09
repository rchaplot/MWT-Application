package com.smartbee.jobdemo.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    @NonNull
    private String name;
    private String address;
    private String createdBy;
    private Date createdAt;
    private String updatedBy;
    private Date updatedAt;

    public Company(@NonNull String name, String address, String createdBy, Date createdAt) {
        this.name = name;
        this.address = address;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }
}
