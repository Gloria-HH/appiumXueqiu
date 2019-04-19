package com.xueqiu.appium.config;

import com.xueqiu.appium.utils.YamlUtils;


public class GlobalConfig {

    private AppiumConfig appium;

    public static GlobalConfig load() {
        return YamlUtils.readConfigFromYaml("/config/globalConfig.yaml", GlobalConfig.class);
    }


    public AppiumConfig getAppium() {
        return appium;
    }

}
