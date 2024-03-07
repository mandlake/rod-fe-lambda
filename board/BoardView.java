package board;


import account.AccountView;
import board.infoBoard.InfoBoardView;
import board.productBoard.ProductBoardView;
import board.userBoard.UserBoardView;
import common.UtilService;
import common.UtilServiceImpl;
import crawler.CrawlerView;
import user.UserView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardView {
    public static void boardView(Scanner sc) throws SQLException {
        while (true){
            System.out.println("=== 0-종료 " +
                    "1-상품게시판 " +
                    "2-고객센터 " +
                    "3-자유게시판 " +
                    "===");
            switch (sc.next()){
                case "0":
                    System.out.println("=== 0-종료 ===");
                    return;
                case "1":
                    System.out.println("=== 1-상품게시판 ===");
                    ProductBoardView.ProductBoardView(sc);
                    break;
                case "2":
                    System.out.println("=== 2-고객센터 ===");
                    InfoBoardView.InfoBoardView(sc);
                    break;
                case "3":
                    System.out.println("=== 3-자유게시판 ===");
                    UserBoardView.UserBoardView(sc);
                    break;
                default: 
                    System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
            }
        }
    }

}