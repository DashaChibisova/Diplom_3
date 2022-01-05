package com.tests;

import com.PO.ForgotPasswordPage;
import com.PO.LoginPage;
import com.PO.MainPage;
import com.PO.RegisterPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginInAccountTest extends BaseClass{
    private LoginPage login;

    @Before
    public void init() {
        login = new LoginPage(driver);
    }

    @DisplayName("Переход на страницу регистрации по кнопке 'Войти в аккаунт' на главной странице ")
    @Test
    public void chekWorkButtonEntryOnMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open().clickOnButtonLogin();

        boolean expected = login.isLoginPage();
        Assert.assertTrue(expected);
    }

    @DisplayName("Переход на страницу регистрации по кнопке 'Личный Кабинет' на главной странице ")
    @Test
    public void chekWorkButtonEntryOnPersonalCabinet() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open().clickOnButtonAccountProfile();

        boolean expected = login.isLoginPage();
        Assert.assertTrue(expected);
    }

    @DisplayName("Переход на страницу регистрации через кнопку в форме регистрации")
    @Test
    public void chekWorkButtonEntryOnFormRegistration() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open().clickOnButtonLogin();

        boolean expected = login.isLoginPage();
        Assert.assertTrue(expected);
    }

    @DisplayName("Переход на страницу регистрации через кнопку в форме восстановления пароля")
    @Test
    public void chekWorkButtonEntryOnFormForgotPassword() {
        ForgotPasswordPage page = new ForgotPasswordPage(driver);
        page.open().clickOnButtonLogin();

        boolean expected = login.isLoginPage();
        Assert.assertTrue(expected);
    }
}
