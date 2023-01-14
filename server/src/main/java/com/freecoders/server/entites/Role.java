package com.freecoders.server.entites;

import javax.persistence.Entity;


public enum Role {
    ADMIN("ADMIN"), USER("USER"), TUTOR("TUTOR"), MODERATOR("MODERATOR");
    private final String code;
    Role(String role) {
        code = role;
    }

    public String getCode() {
        return code;
    }

}
