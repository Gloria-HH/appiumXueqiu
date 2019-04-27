package com.parameter;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;


public class Junit5ParameterTest {

    static List<String> fruits;
    static List<String> animals;

    @BeforeAll
    public static void setup() {
        fruits = Lists.newArrayList("apple", "banana", "lemon, lime");
        animals = Lists.newArrayList("dog", "cat", "snake");
    }

    @ParameterizedTest(name = "{index} ==> fruit=''{0}'', rank={1}")
    @CsvSource({"apple, 1", "banana, 2", "'lemon, lime', 3"})
    void testFruit(String fruit, int rank) {
        assertThat(fruits, hasItems(fruit));
    }

    @ParameterizedTest
    @ValueSource(strings = {"dog", "cat", "snake"})
    void testAnimal(String animal) {
        assertThat(animals, hasItems(animal));
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, names = {"DAYS", "HOURS"})
    void testWithEnumSourceInclude(TimeUnit timeUnit) {
        assertThat(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS), hasItems(timeUnit));
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithExplicitLocalMethodSource(String argument) {
        assertThat(fruits, hasItems(argument));
    }

    static Stream<String> stringProvider() {
        return Stream.of("apple", "banana");
    }

    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    void testWithMultiArgMethodSource(String str, int num, List<String> list) {
        assertThat(5, is(str.length()));
        assertThat(num, lessThanOrEqualTo(2));
        assertThat(2, is(list.size()));

    }

    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                arguments("apple", 1, Arrays.asList("a", "b")),
                arguments("lemon", 2, Arrays.asList("x", "y"))
        );
    }


}
