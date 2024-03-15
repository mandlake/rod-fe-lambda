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
import java.util.function.Function;

public enum Navigation {
    EXIT("x", sc -> {
        System.exit(0);
        return "0";
    }),
    USER("usr", sc -> {
        try {
            UserView.userView(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "종료되었습니다.";
    }),
    ACCOUNT("acc", sc -> {
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
    ARTICLE("art", sc -> {
        ArticleView.articleView(sc);
        return "종료되었습니다.";
    }),
    BOARD("bbs", sc -> {
        try {
            BoardView.boardView(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "종료되었습니다.";
    }),
    CREATE("mk", sc -> {
        try {
            MenuController.getInstance().createTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "테이블이 생성되었습니다.";
    }),
    REMOVE("rm", sc-> {
        try {
            MenuController.getInstance().removeTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "테이블이 제거되었습니다.";
    }),
    ERROR("error", sc-> "다시 입력해 주세요.");
    private final String s;
    private final Function<Scanner, String> function;

    Navigation(String s, Function<Scanner, String> function) {
        this.s = s;
        this.function = function;
    }

    public static String goToPage(Scanner sc) throws SQLException {
        List<?> navLs = MenuController.getInstance().returnAllNavigate(sc);


        System.out.println("=== x-Exit usr-User acc-Account " +
                "cwl-Crawler art-Article bbs-Board scc-Soccer ===");
        String s = sc.next();
        return Arrays.stream(values())
                .filter(o -> o.s.equals(s))
                .findFirst()
                .orElse(ERROR)
                .function.apply(sc);
    }
}
