package com.rod.api.board.infoBoard;

import java.sql.SQLException;
import java.util.Scanner;

public class InfoBoardView {
    public static void InfoBoard(Scanner sc) throws SQLException {
        InfoBoardController controller = new InfoBoardController();
        while (true) {
            System.out.println("[사용자메뉴] 0-종료 1-게시글등록 2-전체목록 3-하나만 4-전체글수" +
                    "5-테이블생성 6-테이블삭제");
            switch (sc.next()) {
                case "0":
                    System.out.println("0-종료");
                    System.out.println(controller.quit());
                    return;
                case "1":
                    System.out.println("1-게시글등록");
                    break;
                case "2":
                    System.out.println("2-전체목록");
                    controller.getAll().forEach(System.out::println);
                    break;
                case "3":
                    System.out.println("3-하나만");
                    break;
                case "4":
                    System.out.println("4-전체글수");
                    break;
                case "5":
                    System.out.println("5-테이블생성");
                    System.out.println(controller.createTable());
                    break;
                case "6":
                    System.out.println("6-테이블삭제");
                    System.out.println(controller.removeTable());
                    break;
                default:
                    System.out.println("잘못 입력했습니다.");
            }
        }
    }
}
