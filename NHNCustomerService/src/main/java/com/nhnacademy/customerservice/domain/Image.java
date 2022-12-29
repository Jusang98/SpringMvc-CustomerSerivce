package com.nhnacademy.customerservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Image {
    private String uploadFilename;
    private String storeFilename;
}