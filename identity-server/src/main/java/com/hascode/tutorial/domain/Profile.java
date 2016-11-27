package com.hascode.tutorial.domain;


import lombok.Data;

import java.io.Serializable;

@Data
public class Profile implements Serializable {
    private Name name;
    private String email;
    private Login login;
    private Picture picture;
}
