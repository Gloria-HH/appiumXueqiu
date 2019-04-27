package com.xueqiu.appium.page;


import com.utils.ArgumentsUtils;
import com.xueqiu.appium.driver.Driver;
import com.xueqiu.appium.utils.YamlUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class LoginTest {

    static MainPage mainPage;
    static ProfilePage profilePage;
    static Map<String, Object> dataMap;

    @BeforeAll
    public static void setUp() {
        dataMap = YamlUtils.readConfigFromYaml("/data/loginTestData.yaml", HashMap.class);
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
    @MethodSource("loginFailureDataStr")
    public void loginFailure(String phone, String password) {
        LoginPage loginPage = profilePage.gotoLoginPage();
        loginPage.loginSuccessByPhone(phone, password);
    }


    static Stream<Arguments> loginFailureDataStr() {
        return ArgumentsUtils.strConvertStrArray(dataMap, "loginFailureDataStr");
    }

    @AfterAll
    public static void teardown() {
        Driver.getCurrentDriver().quit();
    }
}