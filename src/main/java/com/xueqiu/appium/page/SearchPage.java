package com.xueqiu.appium.page;

import com.xueqiu.appium.driver.Driver;
import com.xueqiu.appium.utils.WaitUtils;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {
    private By searchContent = By.id("search_input_text");
    private By cancel = By.id("action_close");

    public SearchPage search(String content) {
        find(searchContent).sendKeys(content);
        return this;
    }

    public MainPage cancel() {
        find(cancel).click();
        return new MainPage();
    }

    public List<String> searchResultList() {
        List<String> list = new ArrayList();
        List<WebElement> webElementList = Driver.getCurrentDriver().findElements(By.id("stockName"));
        for (WebElement element : webElementList) {
            list.add(element.getText());
        }
        return list;
    }

    public List<String> follow() {
        List<String> list = new ArrayList<String>();
        clickFollowBtn();

        AndroidElement didSelect = (AndroidElement) find(By.id("followed_btn"));
        list.add(didSelect.getAttribute("resourceId"));
        return list;

    }

    private String clickFollowBtn() {
        AndroidElement willSelect = (AndroidElement) find(By.xpath("//*[contains(@resource-id, 'follow_btn')]"));
        String attribute = willSelect.getAttribute("resourceId");
        willSelect.click();
        return attribute;
    }

    public List<String> unFollow() {
        List<String> list = new ArrayList<String>();
        clickFollowBtn();
        AndroidElement followed = (AndroidElement) find(By.id("followed_btn"));
        followed.click();
        AndroidElement unfollow = (AndroidElement) find(By.id("follow_btn"));
        list.add(unfollow.getAttribute("resourceId"));
        return list;

    }

    public List<String> unFollowAll() {
        List<String> attributeList = new ArrayList<String>();
        List<WebElement> list = findALL(By.id("followed_btn"));
        for (WebElement webElement : list) {
            webElement = WaitUtils.waitElementLocate(Driver.getCurrentDriver(), 5, By.id("followed_btn"));
            webElement.click();
        }
        return attributeList;

    }


}
