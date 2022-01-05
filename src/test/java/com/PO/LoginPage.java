package com.PO;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.PO.MainPage.URL;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private static final String URL_LOGIN = URL + "login";

    @FindBy(xpath = "//*[@name = 'Пароль']")
    public WebElement passwordWeb;

    @FindBy(xpath = "(//*[contains(@class, 'input pr-6 pl-6')]/input)[1]")
    public WebElement emailWeb;

    @FindBy(xpath = "//button[contains(text(),'Войти')]")
    public WebElement buttonEnter;

    @FindBy(xpath = "//*[contains(@class, 'Auth_login')]/h2[contains(text(), 'Вход')]")
    public WebElement isLoginPage;

    @Step
    public MainPage login(String email, String password) {
        wait.until(ExpectedConditions.visibilityOf(isLoginPage));
        emailWeb.click();
        emailWeb.sendKeys(email);
        passwordWeb.click();
        passwordWeb.sendKeys(password);
        buttonEnter.click();
        return new MainPage(driver);
    }

    public boolean isLoginPage() {
        return wait.until(ExpectedConditions.urlToBe(URL_LOGIN));
    }
}
