package com.xueqiu.appium.driver;

import com.xueqiu.appium.config.GlobalConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static AndroidDriver driver;

    public static void start() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        GlobalConfig globalConfig = GlobalConfig.load();
        globalConfig.getAppium().getCapabilities().keySet().forEach(key -> {
            Object value = globalConfig.getAppium().getCapabilities().get(key);
            desiredCapabilities.setCapability(key, value);
        });
        URL remoteUrl = null;
        try {
            remoteUrl = new URL(globalConfig.getAppium().getUrl());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(globalConfig.getAppium().getWaitTime(), TimeUnit.SECONDS);
    }

    public static AppiumDriver getCurrentDriver() {
        return driver;
    }


}
