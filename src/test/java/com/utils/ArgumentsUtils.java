package com.utils;

import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ArgumentsUtils {
    public static Stream<Arguments> mapConvertStrArray(Map<String, Object> dataMap, String key) {
        List<Map<String, Object>> list = (List<Map<String, Object>>) dataMap.get(key);
        Stream<Object[]> str = list
                .stream()
                .map(s -> {
                            String[] valueArray = new String[s.keySet().size()];
                            s.values().toArray(valueArray);
                            return valueArray;
                        }
                );
        return str.map(Arguments::of);
    }

    public static Stream<Arguments> strConvertStrArray(Map<String, Object> dataMap, String key) {
        List<String> list = (List<String>) dataMap.get(key);
        Stream<String[]> stream = list.stream().map(s -> s.split(","));
        return stream.map(Arguments::of);
    }

}
