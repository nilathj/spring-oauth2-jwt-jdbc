package com.hascode.tutorial.domain;

import lombok.Data;

import java.io.Serializable;
import java.net.URL;

@Data
public class Picture implements Serializable {
    private URL large;
    private URL medium;
    private URL thumbnail;
}
