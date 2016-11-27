package com.hascode.tutorial.exceptions;

import static java.lang.String.format;

public class ProfileNotFoundException extends RuntimeException {
    public ProfileNotFoundException(String username) {
        super(format("Profile with username %s does not exist", username));
    }
}
