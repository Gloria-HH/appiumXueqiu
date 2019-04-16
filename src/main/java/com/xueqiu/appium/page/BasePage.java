package com.xueqiu.appium.page;

import com.xueqiu.appium.driver.Driver;
import com.xueqiu.appium.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {

    public WebElement find(final By locator) {
        try {
            return Driver.getCurrentDriver().findElement(locator);
        } catch (NoSuchElementException e) {
            bulletBox();
            return WaitUtils.wait(Driver.getCurrentDriver(), 5, locator);
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
        try {
            By next = text("下次再说");
            Driver.getCurrentDriver().findElement(next).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
