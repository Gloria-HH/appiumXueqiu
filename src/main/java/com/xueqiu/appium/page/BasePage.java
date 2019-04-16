package com.xueqiu.appium.page;

import com.xueqiu.appium.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    public WebElement find(final By locator) {
        try {
            return Driver.getCurrentDriver().findElement(locator);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            By next = text("下次再说");
            if (next != null) {
                Driver.getCurrentDriver().findElement(next).click();
            }
            WebDriverWait wait = new WebDriverWait(Driver.getCurrentDriver(), 3);
            WebElement webElement = wait.until(new ExpectedCondition<WebElement>() {
                public WebElement apply(WebDriver d) {
                    return d.findElement(locator);
                }
            });
            return webElement;

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

}
