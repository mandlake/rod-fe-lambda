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
import java.util.function.Supplier;

import static java.time.chrono.JapaneseEra.values;

public enum NavigationOfSupply {
    EXIT("x", () -> {
        Scanner sc = new Scanner(System.in);
        System.exit(0);
        return "0";
    }),
    USER("u", () -> {
        Scanner sc = new Scanner(System.in);
        try {
            UserView.userView(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "종료되었습니다.";
    }),
    BOARD("b", () -> {
        Scanner sc = new Scanner(System.in);
        try {
            BoardView.boardView(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "종료되었습니다.";
    }),
    ACCOUNT("a", () -> {
        Scanner sc = new Scanner(System.in);
        AccountView.accontView(sc);
        return "종료되었습니다.";}),
    CRAWLER("c", () -> {
        Scanner sc = new Scanner(System.in);
        try {
            CrawlerView.crawlerView(sc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "종료되었습니다.";
    });
    private final String s;
    private final Supplier<String> supplier;

    NavigationOfSupply(String s, Supplier<String> supplier) {
        this.s = s;
        this.supplier = supplier;
    }

    public static String goToPage(Scanner sc) {
        System.out.println("=== x-Exit u-User b-Board a-Account c-Crawler ===");
        return getMainPage(sc.next()).supplier.get();
    }

    private static NavigationOfSupply getMainPage(String s) {
        return Arrays.stream(values())
                .filter(o -> o.s.equals(s))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("다시 입력해 주세요."));
    }
}
