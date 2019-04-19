package com.xueqiu.appium.config;

import com.xueqiu.appium.utils.YamlUtils;

import java.util.Map;

public class BulletBoxConfig {
    private Map<String, Object> boxMap;

    public static BulletBoxConfig load() {
        return YamlUtils.readConfigFromYaml("/config/bulletBoxConfig.yaml", BulletBoxConfig.class);
    }

    public Map<String, Object> getBoxMap() {
        return boxMap;
    }

}
