package com.warestone_company.NCprojects.java.spring.lab_1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestInfo {
    private String browser, time;

    public void clear(){
        browser = null;
        time = null;
    }
}
