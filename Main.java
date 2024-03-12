package com.rod.api;

import com.rod.api.account.AccountView;
import com.rod.api.board.BoardView;
import com.rod.api.crawler.CrawlerView;
import com.rod.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;


enum MainPage {
    EXIT("x"){
        @Override
        public void display(Scanner scanner) {
            System.out.println("Exiting the program.");
            System.exit(0);
        }
    },
    USER("u"){
        @Override
        public void display(Scanner scanner) throws SQLException, IOException {
            UserView.userView(scanner);
        }
    },
    BOARD("b"){
        @Override
        public void display(Scanner scanner) throws SQLException {
            BoardView.boardView(scanner);
        }
    },
    ACCOUNT("a"){
        @Override
        public void display(Scanner scanner) {
            AccountView.accontView(scanner);
        }
    },
    CRAWLER("c"){
        @Override
        public void display(Scanner scanner) throws IOException {
            CrawlerView.crawlerView(scanner);
        }
    };
    private final String s;

    MainPage(String s) {
        this.s = s;
    }

    public static MainPage  getMainPage(String s) {
        for (MainPage page : values()) {
            if (page.s.equals(s)) {
                return page;
            }
        }
        return null;
    }

    public void display(Scanner scanner) throws IOException, SQLException {
        // 각 enum 상수마다 다른 동작을 수행하도록 설정
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

            String choice = sc.next();
            MainPage mainPage = MainPage.getMainPage(choice);

            if (mainPage == null) {
                System.out.println("Invalid choice.");
                continue;
            }

            mainPage.display(sc);
        }
    }
}