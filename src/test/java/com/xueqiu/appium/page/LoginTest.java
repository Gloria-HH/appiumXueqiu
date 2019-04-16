package com.xueqiu.appium.page;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.IsEqual.*;


public class LoginTest {

    static MainPage mainPage;
    static ProfilePage profilePage;

    @BeforeAll
    public static void setUp() {
        mainPage = MainPage.start();
        profilePage = mainPage.gotoProfilePage();
    }

    @ParameterizedTest
    @CsvSource({
            "12345678901,XXXXXXXXXXX,用户名或密码错误",
            "123456789, xxxxxxxx, 手机号码填写错误"
    })
    public void loginFailure(String phone, String password, String exception) {
        LoginPage loginPage = profilePage.gotoLoginPage();
        loginPage.loginFailByPhone(phone, password);
        assertThat(loginPage.getMessage(), equalTo(exception));
        profilePage = loginPage.gotoProfilePage();
    }

    @ParameterizedTest
    @CsvSource({
            "12345678901,XXXXXXXXXXX",
    })
    public void loginFailure(String phone, String password) {
        LoginPage loginPage = profilePage.gotoLoginPage();
        loginPage.loginSuccessByPhone(phone, password);
    }


}