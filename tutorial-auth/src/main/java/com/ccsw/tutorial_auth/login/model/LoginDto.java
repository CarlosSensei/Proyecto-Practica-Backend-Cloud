package com.ccsw.tutorial_auth.login.model;

import org.antlr.v4.runtime.misc.NotNull;

public class LoginDto {

    @NotNull
    private String user;
    private String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
