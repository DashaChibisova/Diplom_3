package com.tests;

import com.PO.ForgotPasswordPage;
import com.PO.LoginPage;
import com.PO.MainPage;
import com.PO.RegisterPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginInAccountTest extends TestSteps{
    private LoginPage login;

    @Before
    public void init() {
        login = new LoginPage(driver);
        user.getRandom(6);
        registration();
    }

    @DisplayName("Можно залогиниться через кнопку 'Войти в аккаунт' на главной странице ")
    @Test
    public void chekWorkButtonEntryOnMainPage() {
        MainPage mainPage = new MainPage(driver);
        open(mainPage.URL);
        mainPage.clickOnButtonLogin();
        boolean expectedMainPage = login.login(user.getEmail(), user.getPassword()).isMainPageIfUserLogin();

        Assert.assertTrue(expectedMainPage);

    }

    @DisplayName("Можно залогиниться через кнопку 'Личный Кабинет' на главной странице ")
    @Test
    public void chekWorkButtonEntryOnPersonalCabinet() {
        MainPage mainPage = new MainPage(driver);
        open(mainPage.URL);
        mainPage.clickOnButtonAccountProfile();
        boolean expectedMainPage = login.login(user.getEmail(), user.getPassword()).isMainPageIfUserLogin();

        Assert.assertTrue(expectedMainPage);
    }

    @DisplayName("Можно залогиниться через кнопку Вход в форме регистрации")
    @Test
    public void chekWorkButtonEntryOnFormRegistration() {
        RegisterPage registerPage = new RegisterPage(driver);
        open(registerPage.URL_REGISTER);
        registerPage.clickOnButtonLogin();
        boolean expectedMainPage = login.login(user.getEmail(), user.getPassword()).isMainPageIfUserLogin();

        Assert.assertTrue(expectedMainPage);
    }

    @DisplayName("Можно залогиниться через кнопку Вход в форме восстановления пароля")
    @Test
    public void chekWorkButtonEntryOnFormForgotPassword() {
        ForgotPasswordPage page = new ForgotPasswordPage(driver);
        open(page.URL_FORGOT_PASSWORD);
        page.clickOnButtonLogin();
        boolean expectedMainPage = login.login(user.getEmail(), user.getPassword()).isMainPageIfUserLogin();

        Assert.assertTrue(expectedMainPage);
    }
}
