package com.smartbee.jobdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseRestResp<T> implements Serializable {
    private int code;
    private String message;
    private T data;
}
