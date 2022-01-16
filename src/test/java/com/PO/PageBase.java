package com.PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

    private static final int TIME = 10;
    protected WebDriver driver;
    protected WebDriverWait wait;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIME);

    }

}
