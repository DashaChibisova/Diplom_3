package com.tests;

import com.PO.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class ConstructorSectionTest extends BaseClass{
    @DisplayName("Работают переходы в разделе «Конструктор» при нажатии на раздел")
    @Test
    public void checkGoToIngredients() {
        MainPage mainPage= new MainPage(driver).open();
        for (int i = mainPage.getCountIngredients()-1; i >= 0; i--) {
            boolean actual = mainPage.clickOnSectionIngredientReturnList(i);
            Assert.assertTrue(actual);
        }
    }
}
