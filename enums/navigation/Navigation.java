package com.rod.api.enums.navigation;

import com.rod.api.account.AccountView;
import com.rod.api.article.ArticleView;
import com.rod.api.board.BoardView;
import com.rod.api.crawler.CrawlerView;
import com.rod.api.menu.MenuController;
import com.rod.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public enum Navigation {
    EXIT("x", sc -> false),
    USER("usr", sc -> {
        try {
            UserView.userView(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    ACCOUNT("acc", sc -> {
        AccountView.accountView(sc);
        return true;
    }),
    CRAWLER("c", sc -> {
        try {
            CrawlerView.crawlerView(sc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    ARTICLE("art", sc -> {
        ArticleView.articleView(sc);
        return true;
    }),
    BOARD("bbs", sc -> {
        try {
            BoardView.boardView(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    CREATE("mk", sc -> {
        try {
            MenuController.getInstance().createTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    REMOVE("rm", sc-> {
        try {
            MenuController.getInstance().removeTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    ERROR("error", sc-> {
        System.out.println("잘못 입력했습니다.");
        return true;
    });
    private final String s;
    private final Predicate<Scanner> predicate;

    Navigation(String s, Predicate<Scanner> predicate) {
        this.s = s;
        this.predicate = predicate;
    }

    public static Boolean goToPage(Scanner sc) throws SQLException {
        List<?> navLs = MenuController.getInstance().returnAllNavigate();
        navLs.forEach(System.out::println);

        System.out.println("=== x-Exit usr-User acc-Account " +
                "cwl-Crawler art-Article bbs-Board scc-Soccer ===");
        String s = sc.next();
        return Arrays.stream(values())
                .filter(o -> o.s.equals(s))
                .findFirst()
                .orElse(ERROR)
                .predicate.test(sc);
    }
}
