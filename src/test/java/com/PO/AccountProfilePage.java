package com.PO;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.PO.MainPage.URL;

public class AccountProfilePage extends PageBase {

    private static final String URL_PROFILE = URL + "account/profile";

    @FindBy(xpath = "//*[contains(@class, 'Account_link')][contains(text(), 'Профиль')]")
    public WebElement buttonProfile;

    @FindBy(xpath = "//*[contains(@class, 'AppHeader_header')][contains(text(), 'Конструктор')]")
    public WebElement buttonConstructor;

    @FindBy(xpath = "//div[contains(@class, 'AppHeader_header')]")
    public WebElement buttonStellarBurgers;

    @FindBy(xpath = "//button[contains(text(), 'Выход')]")
    public WebElement buttonExit;

    public AccountProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step
    public boolean isAccountProfile() {
        wait.until(ExpectedConditions.urlToBe(URL_PROFILE));
        return buttonProfile.isDisplayed();
    }

    @Step
    public MainPage clickOnButtonConstructor() {
        buttonConstructor.click();
        return new MainPage(driver);
    }

    @Step
    public MainPage clickOnButtonStellarBurgers() {
        buttonStellarBurgers.click();
        return new MainPage(driver);
    }

    @Step
    public LoginPage clickOnButtonExit() {
        wait.until(ExpectedConditions.visibilityOf(buttonExit));
        buttonExit.click();
        return new LoginPage(driver);
    }
}
