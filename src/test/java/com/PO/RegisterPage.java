package com.PO;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.PO.MainPage.URL;

public class RegisterPage extends PageBase {

    public static final String URL_REGISTER = URL + "register";

    @FindBy(xpath = "//*[@name = 'Пароль']")
    public WebElement passwordWeb;

    @FindBy(xpath = "(//*[contains(@class, 'input pr-6 pl-6')]/input)[2]")
    public WebElement emailWeb;

    @FindBy(xpath = "(//*[contains(@class, 'input pr-6 pl-6')]/input)[1]")
    public WebElement namedWeb;

    @FindBy(xpath = "//*[text()='Зарегистрироваться']")
    public WebElement buttonRegister;

    @FindBy(xpath = "//*[@class = 'input__container']//*[@class ='input__error text_type_main-default']")
    public WebElement textErrorRegisterPassword;

    @FindBy(xpath = "//*[@class = 'input__error text_type_main-default']")
    public WebElement textErrorRegisterEmail;

    @FindBy(xpath = "//*[contains(@class, 'Auth_link')][contains(text(), 'Войти')]")
    public WebElement buttonLogin;

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step
    public RegisterPage open() {
        driver.get(URL_REGISTER);
        return this;
    }

    @Step
    public RegisterPage inputUserEmail(String email) {
        emailWeb.click();
        emailWeb.sendKeys(email);
        return this;
    }

    @Step
    public RegisterPage inputUserName(String name) {
        namedWeb.click();
        namedWeb.sendKeys(name);
        return this;
    }

    @Step
    public RegisterPage inputUserPassword(String password) {
        passwordWeb.click();
        passwordWeb.sendKeys(password);
        return this;
    }

    @Step
    public RegisterPage registration(String email, String password, String name) {
        wait.until(ExpectedConditions.elementToBeClickable(emailWeb));
        inputUserEmail(email);
        inputUserPassword(password);
        inputUserName(name);
        return this;
    }

    @Step
    public void clickButtonRegister() {
        buttonRegister.click();
    }

    @Step
    public String getTextRegisterErrorPassword() {
        return textErrorRegisterPassword.getText();
    }

    @Step
    public String getTextRegisterErrorEmail() {
        wait.until(ExpectedConditions.visibilityOf(textErrorRegisterEmail));
        return textErrorRegisterEmail.getText();
    }

    @Step
    public LoginPage clickOnButtonLogin() {
        buttonLogin.click();
        return new LoginPage(driver);
    }
}
