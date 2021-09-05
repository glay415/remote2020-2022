package com.example.instagramclone.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CMRespDto<T> {
    private int code;
    private String message;
    private T data;
}
