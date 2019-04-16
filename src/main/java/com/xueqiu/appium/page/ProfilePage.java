package com.xueqiu.appium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProfilePage extends BasePage{

    public LoginPage gotoLoginPage() {
        find(By.id("tv_login")).click();
        return new LoginPage();
    }
}
