package com.hascode.tutorial.domain;

import lombok.*;

import java.io.Serializable;

@Data
public class Login implements Serializable {
    String username;
    String password;
    String salt;
    String md5;
    String sha1;
    String sha256;
}
