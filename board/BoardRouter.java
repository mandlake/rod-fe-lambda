package com.rod.api.board;

import com.rod.api.board.infoBoard.InfoBoardView;
import com.rod.api.board.productBoard.ProductBoardView;
import com.rod.api.board.userBoard.UserBoard;
import com.rod.api.board.userBoard.UserBoardView;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum BoardRouter {
    EXIT("x", sc -> false),
    MAKE("mk", sc -> {
        System.out.println("생성되었습니다.");
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
