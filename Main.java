package com.rod.api;

import com.rod.api.account.AccountView;
import com.rod.api.board.BoardView;
import com.rod.api.crawler.CrawlerView;
import com.rod.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;


enum MainPage {
    EXIT("x"),
    USER("u"),
    BOARD("b"),
    ACCOUNT("a"),
    CRAWLER("c");
    private final String s;

    MainPage(String s) {
        this.s = s;
    }

    public static String getMainPage(String s) {
        return s;
    }


}

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("=== x-Exit " +
                    "u-User " +
                    "b-Board " +
                    "a-Account " +
                    "c-Crawler ===");

            System.out.println(MainPage.getMainPage(sc.next()));

            switch (sc.next()){
                case "x": return;
                case "u": UserView.userView(sc); break;
                case "b": BoardView.boardView(sc); break;
                case "a": AccountView.accontView(sc); break;
                case "c": CrawlerView.crawlerView(sc); break;
            }
        }
    }
}