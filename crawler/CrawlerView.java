package com.rod.api.crawler;

import java.io.IOException;
import java.util.*;

public class CrawlerView {
    public static void crawlerView(Scanner scanner) throws IOException {
        CrawlerController controller = new CrawlerController();
        Map<String, ?> musicLank;
        while(true){
            System.out.println("[사용자메뉴] 0-종료 1-벅스뮤직 2-멜론뮤직 " +
                    "3-ID검색 4-비번변경 5-탈퇴 6-회원목록 7-이름검색 " +
                    "8-직업검색 9-회원수");
            switch (scanner.next()){
                case "0":
                    System.out.println("종료");
                    return;
                case "1":
                    System.out.println("1-벅스뮤직");
                    musicLank = controller.findBugsMusic();
                    System.out.println(musicLank);
                    break;
                case "2":
                    System.out.println("2-멜론뮤직");
                    musicLank = controller.findMelonMusic();
                    System.out.println(musicLank);
                    break;
                case "3":
                    System.out.println("3-ID 검색");

                    break;
                case "4":
                    System.out.println("4-비번변경");

                    break;
                case "5":
                    System.out.println("5-탈퇴");

                    break;
                case "6":
                    System.out.println("6-회원목록");

                    break;
                case "7":
                    System.out.println("7-이름검색");

                    break;
                case "8":
                    System.out.println("8-직업검색");

                    break;
                case "9":
                    System.out.println("9-회원수");


                    break;


            }

        }

    }
}