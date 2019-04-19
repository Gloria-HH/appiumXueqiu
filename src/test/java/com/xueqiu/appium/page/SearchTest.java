package com.xueqiu.appium.page;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SearchTest {
    static MainPage mainPage;
    static SearchPage searchPage;

    @BeforeAll
    public static void setUp() {
        mainPage = MainPage.start();
        searchPage = mainPage.gotoSearchPage();
    }

    @ParameterizedTest
    @MethodSource("searchContent")
    public void search(String stockCode, String stockName) {
        searchPage.search(stockCode);
        List<String> list = searchPage.searchResultList();
        assertThat(list, hasItems(stockName));

    }
    static Stream<Arguments> searchContent() {
        return Stream.of(
                arguments("pdd", "拼多多"),
                arguments("sogo", "搜狗")
        );

    }

    @ParameterizedTest
    @CsvSource({
            "pdd,com.xueqiu.android:id/followed_btn"
    })
    public void follow(String stockCode, String attribute) {
        searchPage.search(stockCode);
        searchPage.unFollowAll();
        List<String> list = searchPage.follow();
        assertThat(list, hasItems(attribute));

    }

    @ParameterizedTest
    @CsvSource({
            "mi,com.xueqiu.android:id/follow_btn"
    })
    public void unFollow(String stockCode, String attribute) {
        searchPage.search(stockCode);
        searchPage.unFollowAll();
        List<String> list = searchPage.unFollow();
        assertThat(list, hasItems(attribute));

    }

    @AfterAll
    public static void teardown() {

    }

}
