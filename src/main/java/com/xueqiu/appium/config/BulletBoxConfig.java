package com.xueqiu.appium.config;

import com.xueqiu.appium.utils.YamlUtils;

import java.util.List;

public class BulletBoxConfig {
    private List<String> bulletBox;

    public static BulletBoxConfig load() {
        return YamlUtils.readConfigFromYaml("/config/bulletBoxConfig.yaml", BulletBoxConfig.class);
    }

    public List<String> getBulletBox() {
        return bulletBox;
    }
}
