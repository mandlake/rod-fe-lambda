package board.productBoard;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductBoardView {
    public static void ProductBoard(Scanner sc) throws SQLException {
        ProductBoardController controller = new ProductBoardController();
        while(true) {
            System.out.println("[사용자메뉴] 0-종료 1-게시글목록 2-단일페이지 3-전체글수 " +
                    "4-테이블생성 5-테이블삭제");
            switch (sc.next()) {
                case "0":
                    System.out.println("0-종료");
                    System.out.println(controller.quit());
                    return;
                case "1":
                    System.out.println("1-게시글목록");
                    controller.getAll().forEach(System.out::println);
                    break;
                case "2":
                    System.out.println("2-단일페이지");
                    System.out.println("페이지 번호를 입력하세요.");
                    System.out.println(controller.getOne(sc));
                    break;
                case "3":
                    System.out.println("3-전체글수");
                    System.out.println(controller.count());
                    break;
                case "4":
                    System.out.println("4-테이블생성");
                    System.out.println(controller.createTable());
                    break;
                case "5":
                    System.out.println("5-테이블삭제");
                    System.out.println(controller.removeTable());
                    break;
                default:
                    System.out.println("다시 입력해주세요.");
            }
        }
    }
}
