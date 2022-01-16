package com.tests;

import com.PO.LoginPage;
import com.PO.MainPage;
import com.PO.RegisterPage;
import io.qameta.allure.Step;

public class TestSteps extends BaseClass{


    @Step
    public void registration() {
        register = new RegisterPage(driver);
        register
                .open()
                .registration(user.getEmail(), user.getPassword(), user.getName())
                .clickButtonRegister();
    }

    @Step
    public MainPage login() {
        user.getRandom(7);
        registration();
        return new LoginPage(driver).login(user.getEmail(), user.getPassword());
    }

    @Step
    public void open(String url) {
        driver.get(url);
    }
}
