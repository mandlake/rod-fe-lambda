package com.rod.api.enums;

import com.rod.api.account.AccountView;
import com.rod.api.board.BoardView;
import com.rod.api.crawler.CrawlerView;
import com.rod.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public enum Navigation {
    EXIT("x", sc -> {
        System.exit(0);
        return "0";
    }),
    USER("u", sc -> {
        try {
            UserView.userView(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "종료되었습니다.";
    }),
    BOARD("b", sc -> {
        try {
            BoardView.boardView(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "종료되었습니다.";
    }),
    ACCOUNT("a", sc -> {
        AccountView.accontView(sc);
        return "종료되었습니다.";}),
    CRAWLER("c", sc -> {
        try {
            CrawlerView.crawlerView(sc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "종료되었습니다.";
    }),

    ERROR("error", scanner-> {
        return "다시 입력해 주세요.";
    });
    private final String s;
    private final Function<Scanner, String> function;

    Navigation(String s, Function<Scanner, String> function) {
        this.s = s;
        this.function = function;
    }

    public static String goToPage(Scanner sc) {
        System.out.println("=== x-Exit u-User b-Board a-Account c-Crawler ===");
        return getMainPage(sc.next()).function.apply(sc);
    }

    private static Navigation getMainPage(String s) {
        return Arrays.stream(values())
                .filter(o -> o.s.equals(s))
                .findFirst()
                .orElse(ERROR);
    }
}
