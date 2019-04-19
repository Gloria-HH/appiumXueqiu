package com.xueqiu.appium.config;

import java.util.Map;

public class AppiumConfig {
    private String url;
    private Integer waitTime;//秒
    private Map<String, Object> capabilities;

    public String getUrl() {
        return url;
    }

    public Integer getWaitTime() {
        return waitTime;
    }

    public Map<String, Object> getCapabilities() {
        return capabilities;
    }


}
