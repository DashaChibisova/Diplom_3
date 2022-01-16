package com.PO;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage extends PageBase {

    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(xpath = "//*[contains(@class, 'AppHeader_header')][contains(text(), 'Личный Кабинет')]")
    public WebElement buttonAccountProfile;

    @FindBy(xpath = "//*[contains(@class, 'button_button')][contains(text(), 'Войти в аккаунт')]")
    public WebElement buttonLogin;

    @FindBy(xpath = "//*[@style = 'display: flex;']/div/span")
    public List<WebElement> buttonIngredient;

    @FindBy(xpath = "(//div[contains(@class, 'BurgerIngredients')]/ul)/a[1]")
    public List<WebElement> listIngredients;

    @FindBy(xpath = "//*[contains(@class, 'button_button')][contains(text(), 'Оформить заказ')]")
    public WebElement buttonCheckout;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step
    public MainPage open() {
        driver.get(URL);
        return this;
    }

    @Step
    public boolean clickOnSectionIngredientReturnList(int numberSection) {
        buttonIngredient.get(numberSection).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(listIngredients));
        return listIngredients.get(numberSection).isDisplayed();
    }

    @Step
    public int getCountIngredients() {
        return buttonIngredient.size();
    }

    @Step
    public void clickOnButtonLogin() {
        buttonLogin.click();
    }

    @Step
    public LoginPage clickOnButtonAccountProfile() {
        buttonAccountProfile.click();
        return new LoginPage(driver);
    }

    @Step
    public boolean isMainPageIfUserLogin() {
        wait.until(ExpectedConditions.urlToBe(URL));
        return buttonCheckout.isDisplayed();
    }
}
