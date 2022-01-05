package com.tests;

import com.PO.LoginPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;

import org.junit.Test;


public class RegistrationTest extends BaseClass {

    @DisplayName("Можно зарегестрироваться, если пароль содержит 7 символов")
    @Test
    public void canBeRegistrWithPasswordSevenCharData() {
        user.getRandom(7);
        registration();
        LoginPage login = new LoginPage(driver);
        boolean expected = login.isLoginPage();
        boolean expectedMainPage = login.login(user.getEmail(), user.getPassword()).isMainPageIfUserLogin();

        Assert.assertTrue(expectedMainPage);
        Assert.assertTrue(expected);
    }

    @DisplayName("Можно зарегестрироваться, если пароль содержит 6 символов")
    @Test
    public void canBeRegistrWithPasswordSixCharData() {
        user.getRandom(6);
        registration();
        LoginPage login = new LoginPage(driver);
        boolean expected = login.isLoginPage();
        boolean expectedMainPage = login.login(user.getEmail(), user.getPassword()).isMainPageIfUserLogin();

        Assert.assertTrue(expectedMainPage);
        Assert.assertTrue(expected);
    }

    @DisplayName("Нельзя зарегестрироваться, если пароль содержит 5 символов")
    @Test
    public void canNotBeRegistrWithPasswordSixCharData() {
        user.getRandom(5);
        registration();
        String errorActual = register.getTextRegisterErrorPassword();
        String expected = "Некорректный пароль";

        Assert.assertEquals(errorActual, expected);
    }

    @DisplayName("Нельзя зарегестрироваться, если емейл уже есть в системе")
    @Test
    public void canNotBeRegistrWithInvalidEmailData() {
        user.getRandom(7);
        String email = user.getEmail();
        registration();
        user.getRandom(7);
        user.setEmail(email);
        registration();
        String errorActual = register.getTextRegisterErrorEmail();
        String expected = "Такой пользователь уже существует";

        Assert.assertEquals(errorActual, expected);
    }
}
