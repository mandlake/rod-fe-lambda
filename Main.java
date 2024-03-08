import account.AccountView;
import board.BoardView;
import crawler.CrawlerView;
import user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("=== x-Exit " +
                    "u-User " +
                    "b-Board " +
                    "a-Account " +
                    "c-Crawler ===");
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