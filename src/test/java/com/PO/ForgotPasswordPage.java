package com.PO;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.PO.MainPage.URL;

public class ForgotPasswordPage extends PageBase {

    public static final String URL_FORGOT_PASSWORD = URL + "forgot-password";

    @FindBy(xpath = "//*[contains(@class, 'Auth_link')][contains(text(), 'Войти')]")
    public WebElement buttonLogin;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step
    public ForgotPasswordPage open() {
        driver.get(URL_FORGOT_PASSWORD);
        return this;
    }

    @Step
    public LoginPage clickOnButtonLogin() {
        buttonLogin.click();
        return new LoginPage(driver);
    }

}
