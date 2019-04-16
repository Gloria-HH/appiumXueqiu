package com.xueqiu.appium.page;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTest {
    MainPage mainPage;
    SearchPage searchPage;

    @BeforeEach
    public void setUp() {
        mainPage = MainPage.start();
        searchPage = mainPage.gotoSearchPage();
    }

    @ParameterizedTest
    @CsvSource({
            "pdd,拼多多",
            "sogo,搜狗"
    })
    public void search(String stockCode, String stockName) {
        searchPage.search(stockCode);
        List<String> list = searchPage.searchResultList();
        assertThat(list, hasItems(stockName));

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

    @AfterEach
    public void teardown() {

    }

}
