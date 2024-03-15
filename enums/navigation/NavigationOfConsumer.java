package com.rod.api.enums.navigation;

import com.rod.api.account.AccountView;
import com.rod.api.board.BoardView;
import com.rod.api.crawler.CrawlerView;
import com.rod.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public enum NavigationOfConsumer {
    EXIT("x", sc -> System.exit(0)),
    USER("u", sc -> {
        try {
            UserView.userView(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    BOARD("b", sc -> {
        try {
            BoardView.boardView(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    ACCOUNT("a", AccountView::accountView),
    CRAWLER("c", sc -> {
        try {
            CrawlerView.crawlerView(sc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }),

    ERROR("error", scanner-> {
        System.out.println("다시 입력해 주세요.");
    });
    private final String s;
    private final Consumer<Scanner> consumer;

    NavigationOfConsumer(String s, Consumer<Scanner> consumer) {
        this.s = s;
        this.consumer = consumer;
    }

    public static void goToPage(Scanner sc) {
        System.out.println("=== x-Exit u-User b-Board a-Account c-Crawler ===");
        String s = sc.next();
        Arrays.stream(values())
                .filter(o -> o.s.equals(s))
                .findFirst()
                .orElse(ERROR).consumer.accept(sc);
    }
}
