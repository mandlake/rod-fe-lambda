package user;

import java.util.Scanner;

public class UserView {
    public static void userView(Scanner sc) {
        UserController userController = new UserController();
        String msg = userController.addUsers();
        System.out.println(" addUsers 결과 : "+msg);
        while(true){
            System.out.println("[사용자메뉴] 0-종료 1-회원가입 2-로그인 " +
                    "3-ID검색 4-비번변경 5-탈퇴 6-회원목록 " +
                    "7-이름검색 8-직업검색 9-회원수");
            switch (sc.next()){
                case "0":
                    System.out.println("종료");
                    return;
                case "1":
                    System.out.println("1-회원가입");
                    msg = userController.join(sc);
                    System.out.println(msg);
                    break;
                case "2":
                    System.out.println("2-로그인");
                    break;
                case "3":
                    System.out.println("3-ID검색");
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