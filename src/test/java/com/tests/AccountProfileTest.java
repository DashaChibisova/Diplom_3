package com.tests;

import com.PO.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountProfileTest extends BaseClass {
    private AccountProfilePage account;
    @Before
    public void init() {
        login().clickOnButtonAccountProfile();
        account = new AccountProfilePage(driver);
    }

    @DisplayName("Переход в личный кабинет по клику на «Личный кабинет» зарегестрированного пользователя")
    @Test
    public void checkGoToAccountProfilePage() {
        boolean actual = account.isAccountProfile();

        Assert.assertTrue(actual);
    }

    @DisplayName("Переход пользователя из личного кабинета в конструктор")
    @Test
    public void checkGoToConstructor() {
        boolean actual = account.clickOnButtonConstructor().isMainPageIfUserLogin();
        Assert.assertTrue(actual);
    }

    @DisplayName("Переход пользователя из личного кабинета на главную страницу путем нажатия на логотип Stellar Burgers")
    @Test
    public void checkGoToMainPage() {
        boolean actual = account.clickOnButtonStellarBurgers().isMainPageIfUserLogin();
        Assert.assertTrue(actual);
    }

    @DisplayName("Проверяет выход из личного кабинета")
    @Test
    public void checkExitWithAccountProfile() {
        boolean actual = account.clickOnButtonExit().isLoginPage();
        Assert.assertTrue(actual);
    }
}
