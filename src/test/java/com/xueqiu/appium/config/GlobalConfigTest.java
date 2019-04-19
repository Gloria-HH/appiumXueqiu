package com.xueqiu.appium.config;

import org.junit.jupiter.api.Test;

public class GlobalConfigTest {
    @Test
    public void test() {
        GlobalConfig globalConfig = GlobalConfig.load();
        System.out.println(globalConfig.getAppium().getUrl());
        System.out.println(globalConfig.getAppium().getCapabilities());

    }
}
