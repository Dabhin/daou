package com.example.app.model;

import lombok.Data;

/**
 * Table: userinfo
 */
@Data
public class Userinfo {
    /**
     * Column: U_ID
     */
    private String uId;

    /**
     * Column: U_PASSWORD
     */
    private String uPassword;

    /**
     * Column: U_AUTH
     */
    private String uAuth;
}