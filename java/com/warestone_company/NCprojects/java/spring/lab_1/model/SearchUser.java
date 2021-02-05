package com.warestone_company.NCprojects.java.spring.lab_1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchUser {
    private String firstName, lastName, email, message;
}
