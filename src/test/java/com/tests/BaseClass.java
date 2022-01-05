package com.tests;

import com.PO.LoginPage;
import com.PO.MainPage;
import com.PO.RegisterPage;
import com.PO.UserData;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class BaseClass {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected UserData user = new UserData();
    protected RegisterPage register;


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

//        ChromeDriverService service = new ChromeDriverService.Builder()
//                .usingDriverExecutable(new File("C:\\yandexdriver.exe"))
//                .build();
//        driver = new ChromeDriver(service);
        wait = new WebDriverWait(driver, TIME);
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }

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

    private static final int TIME = 10;
}
