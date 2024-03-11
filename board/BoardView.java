package com.rod.api.board;


import com.rod.api.account.AccountView;
import com.rod.api.board.infoBoard.InfoBoardView;
import com.rod.api.board.productBoard.ProductBoardView;
import com.rod.api.board.userBoard.UserBoardView;
import com.rod.api.common.UtilService;
import com.rod.api.common.UtilServiceImpl;
import com.rod.api.crawler.CrawlerView;
import com.rod.api.user.UserView;

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
                    ProductBoardView.ProductBoard(sc);
                    break;
                case "2":
                    System.out.println("=== 2-고객센터 ===");
                    InfoBoardView.InfoBoard(sc);
                    break;
                case "3":
                    System.out.println("=== 3-자유게시판 ===");
                    UserBoardView.UserBoard(sc);
                    break;
                default: 
                    System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
            }
        }
    }

}