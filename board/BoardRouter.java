package com.rod.api.board;

import com.rod.api.board.infoBoard.InfoBoardView;
import com.rod.api.board.productBoard.ProductBoardView;
import com.rod.api.board.userBoard.UserBoardView;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum BoardRouter {
    EXIT("0", sc -> {
        return false;
    }),
    PRODUCT("1", sc -> {
        System.out.println("=== 1-상품게시판 ===");
        try {
            ProductBoardView.ProductBoard(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    INFO("2", sc -> {
        System.out.println("=== 2-고객센터 ===");
        try {
            InfoBoardView.InfoBoard(sc);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    USER("3", sc -> {
        System.out.println("=== 3-자유게시판 ===");
        UserBoardView.UserBoard(sc);
        return true;
    }),
    ERROR("", sc -> {
        System.out.println("잘못 입력했습니다.");
        return true;
    })
    ;

    private final String s;
    private final Predicate<Scanner> predicate;

    BoardRouter(String s, Predicate<Scanner> predicate) {
        this.s = s;
        this.predicate = predicate;
    }

    public static boolean execute(Scanner sc) {
        System.out.println("=== 0-종료 1-상품게시판 2-고객센터 3-자유게시판 ===");
        String s = sc.next();
        return Stream.of(values())
                .filter(i -> i.s.equals(s))
                .findAny().orElse(ERROR).predicate.test(sc);
    }
}
