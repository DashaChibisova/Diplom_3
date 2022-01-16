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

    private static final int TIME = 10;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected RegisterPage register;
    protected UserData user = new UserData();

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
}
