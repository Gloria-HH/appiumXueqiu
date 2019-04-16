package com.xueqiu.appium.page;

import com.xueqiu.appium.driver.Driver;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    By profile = By.id("user_profile_icon");
    By search = By.id("tv_search");

    public static MainPage start() {
        Driver.start();
        return new MainPage();
    }

    public ProfilePage gotoProfilePage() {
        find(profile).click();
        return new ProfilePage();

    }

    public SearchPage gotoSearchPage() {
        find(search).click();
        return new SearchPage();

    }
}
