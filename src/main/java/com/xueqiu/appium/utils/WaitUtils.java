package com.xueqiu.appium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    public static WebElement wait(WebDriver driver, Integer timout, By by) {
        WebDriverWait wait = new WebDriverWait(driver, timout);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
}
