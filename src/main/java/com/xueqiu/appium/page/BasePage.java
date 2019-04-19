package com.xueqiu.appium.page;

import com.google.common.collect.Maps;
import com.xueqiu.appium.config.BulletBoxConfig;
import com.xueqiu.appium.driver.Driver;
import com.xueqiu.appium.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class BasePage {


    public WebElement find(final By locator) {
        try {
            return Driver.getCurrentDriver().findElement(locator);
        } catch (NoSuchElementException e) {
            bulletBox();
            return WaitUtils.waitElementLocate(Driver.getCurrentDriver(), 3, locator);
        }

    }

    public By locate(String locator) {
        if (locator.matches("/.*")) {
            return By.xpath(locator);
        } else {
            return By.id(locator);
        }
    }

    public By text(String content) {
        return By.xpath("//*[@text='" + content + "']");
    }

    public List<WebElement> findALL(final By locator) {
        return Driver.getCurrentDriver().findElements(locator);
    }

    public void bulletBox() {
        BulletBoxConfig bulletBoxConfig = BulletBoxConfig.load();
        bulletBoxConfig.getBulletBox().forEach(key -> {
            try {
                System.out.println("————————"+key);
                By next = text(key);
                Driver.getCurrentDriver().findElement(next).click();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } );
    }

}
