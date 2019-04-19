package com.xueqiu.appium.config;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;
import org.junit.jupiter.api.Test;

public class GlobalConfigTest {
    @Test
    public void test() {
        GlobalConfig globalConfig = GlobalConfig.load();
        System.out.println(globalConfig.getAppium().getUrl());
        System.out.println(globalConfig.getAppium().getCapabilities());

    }
    @Test
    public void boxTest(){
        BulletBoxConfig bulletBoxConfig = BulletBoxConfig.load();
        bulletBoxConfig.getBulletBox().forEach(key -> {
            try {
                System.out.println(key);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } );
    }

}
