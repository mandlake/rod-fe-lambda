package board.productBoard;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductBoardView {
    public static void ProductBoardView(Scanner sc) throws SQLException {
        ProductBoardController controller = new ProductBoardController();
        while(true) {
            System.out.println("[사용자메뉴] 0-종료 1-게시글목록 2-단일페이지 " +
                    "3-이름검색 4-전체글수");
            switch (sc.next()) {
                case "0":
                    System.out.println("0-종료");
                    return;
                case "1":
                    System.out.println("1-게시글목록");
                    controller.getAll();
                    break;
                case "2":
                    System.out.println("2-단일페이지");
                    break;
                case "3":
                    System.out.println("3-이름검색");
                    break;
                case "4":
                    System.out.println("4-전체글수");
                    break;
                default:
                    System.out.println("다시 입력해주세요.");
            }
        }
    }
}
