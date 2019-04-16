package com.xueqiu.appium.page;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private By phoneOrOthers = By.id("tv_login_by_phone_or_others");
    private By accountLogin = By.id("tv_login_with_account");
    private By loginAccount = By.id("login_account");
    private By loginPassword = By.id("login_password");
    private By login = By.id("button_next");
    private By errorMsg = By.id("md_content");
    private By errorConfirmBtn = By.id("md_buttonDefaultPositive");
    private By backButton = By.id("iv_action_back");
    private String message;


    public LoginPage loginFailByPhone(String phone, String password) {
        find(phoneOrOthers).click();
        find(accountLogin).click();
        find(loginAccount).sendKeys(phone);
        find(loginPassword).sendKeys(password);
        find(login).click();
        message = find(errorMsg).getText();
        find(errorConfirmBtn).click();
        return this;
    }

    public MainPage loginSuccessByPhone(String phone, String password) {
        find(phoneOrOthers).click();
        find(accountLogin).click();
        find(loginAccount).sendKeys(phone);
        find(loginPassword).sendKeys(password);
        find(login).click();
        return new MainPage();
    }

    public String getMessage() {
        return message;
    }


    public ProfilePage gotoProfilePage() {
        find(backButton).click();
        return new ProfilePage();
    }
}
