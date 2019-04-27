package com.yaml;

import com.utils.ArgumentsUtils;
import com.utils.YamlFileSource;
import com.xueqiu.appium.utils.YamlUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YamlTest {

    static Map<String, Object> dataMap;

    @BeforeAll
    public static void setUp() {
        dataMap = YamlUtils.readConfigFromYaml("/data/loginTestData.yaml", HashMap.class);
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithSimpleMethodSource(String stockCode, String stockName) {
        System.out.println(stockCode + ":" + stockName);
    }

    static Stream<Arguments> stringProvider() {
        return ArgumentsUtils.strConvertStrArray(dataMap, "loginFailureDataStr");
    }

    @ParameterizedTest
    @MethodSource("mapProvider")
    void testWithSimpleMethodSource1(String str, String str1) {
        System.out.println(str + ":" + str1);
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
        assertEquals(result, dataFromYaml.getResult());
        assertEquals("junit5", dataFromYaml.getMap().get("name"));
    }

}
