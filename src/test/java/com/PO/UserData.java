package com.PO;

import org.apache.commons.lang3.RandomStringUtils;

public class UserData {

    public static final String EMAIL_POSTFIX = "@yandex.ru";
    private  String email;
    private  String password;
    private  String name;

    public UserData(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
    public UserData() {
    }

    public UserData getRandom(int countPassword) {
        this.name = RandomStringUtils.randomAlphabetic(10);
        this.email =RandomStringUtils.randomAlphabetic(10) + EMAIL_POSTFIX;
        this.password = RandomStringUtils.randomAlphabetic(countPassword);
        return new UserData(email, password, name);
    }

    public String getEmail() {
        return email;
    }

    public UserData setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserData setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserData setName(String name) {
        this.name = name;
        return this;
    }
}
