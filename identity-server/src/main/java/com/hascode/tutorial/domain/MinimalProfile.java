package com.hascode.tutorial.domain;

import lombok.Data;

import java.io.Serializable;
import java.net.URL;

@Data
public class MinimalProfile implements Serializable {
    private final String username;
    private final Name name;
    private final URL thumbnail;

    public MinimalProfile(Profile profile) {
        name = profile.getName();
        username = profile.getLogin().getUsername();
        thumbnail = profile.getPicture().getThumbnail();
    }
}
