package com.yaml;

import com.google.common.collect.Lists;
import com.utils.ArgumentsUtils;
import com.utils.YamlFileSource;
import com.xueqiu.appium.utils.YamlUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class YamlTest {

    static Map<String, Object> dataMap;

    @BeforeAll
    public static void setUp() {
        dataMap = YamlUtils.readConfigFromYaml("/data/loginTestData.yaml", HashMap.class);
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithSimpleMethodSource(String stockCode, String stockName) {
        List<String> list = Lists.newArrayList("拼多多", "搜狗");
        assertThat(list, hasItem(stockName));
    }

    static Stream<Arguments> stringProvider() {
        return ArgumentsUtils.strConvertStrArray(dataMap, "loginFailureDataStr");
    }

    @ParameterizedTest
    @MethodSource("mapProvider")
    void testWithSimpleMethodSource1(String stockCode, String stockName) {
        List<String> list = Lists.newArrayList("拼多多", "搜狗");
        assertThat(list, hasItem(stockName));
    }

    static Stream<Arguments> mapProvider() {
        return ArgumentsUtils.mapConvertStrArray(dataMap, "loginFailureDataMap");
    }


    @YamlFileSource(resources = {"/data/yamlTestData.yaml"}, type = DataFromYaml.class)
    @ParameterizedTest
    public void sumNumberListTest(DataFromYaml dataFromYaml) {
        boolean enableAbs = dataFromYaml.isEnableAbs();
        Integer result = dataFromYaml.getList().stream()
                .mapToInt((i -> enableAbs ? Math.abs(i) : i)).sum();
        assertThat(result, equalTo(dataFromYaml.getResult()));
        assertThat("junit5", equalTo(dataFromYaml.getMap().get("name")));
    }

}
