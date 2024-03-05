package user;

import java.util.Map;
import java.util.Scanner;

public class UserView {
    public static void userView(Scanner scanner) {
        UserController controller = new UserController();
        String msg = controller.addUsers();
        System.out.println(" addUsers 결과 : "+msg);
        while(true){
            System.out.println("[사용자메뉴] 0-종료 1-회원가입 2-로그인 " +
                    "3-ID검색 4-비번변경 5-탈퇴 6-회원목록 " +
                    "7-이름검색 8-직업검색9-회원수");
            switch (scanner.next()){
                case "0":
                    System.out.println("종료");
                    return;
                case "1":
                    System.out.println("1-회원가입");
                    System.out.println("ID, 비밀번호, 이름, 주민번호," +
                            " 전화번호, 주소, 직업을 입력해주세요");
                    System.out.println("회원가입 결과 : "
                            + controller.save(scanner));
                    break;
                case "2":
                    System.out.println("2-로그인");
                    System.out.println("아이디와 비밀번호를 입력하세요.");
                    System.out.println("로그인 결과 : "
                            + controller.login(scanner));
                    break;
                case "3":
                    System.out.println("3-ID 검색");
                    System.out.println("검색할 아이디를 입력하세요.");
                    System.out.println(controller.getOne(scanner));
                    break;
                case "4":
                    System.out.println("4-비번변경");
                    System.out.println("아이디와 비밀번호를 입력하세요.");
                    System.out.println(controller.updatePassword(scanner));
                    break;
                case "5":
                    System.out.println("5-탈퇴");
                    System.out.println("아이디를 입력하세요.");
                    System.out.println(controller.delete(scanner));
                    break;
                case "6":
                    System.out.println("6-회원목록");
                    Map<String, ?> users = controller.getUserMap();
                    users.forEach((k,v)->{
                        System.out.printf("아이디: %s, 회원정보: %s\n", k, v);
                    });
                    break;
                case "7":
                    System.out.println("7-이름검색");
                    System.out.println("이름을 입력하세요.");
                    controller
                            .findUsersByName(scanner)
                            .forEach(System.out::println);
                    break;
                case "8":
                    System.out.println("8-직업검색");
                    System.out.println("직업을 입력하세요.");
                    controller
                            .findUsersByJob(scanner)
                            .forEach(System.out::println);
                    break;
                case "9":
                    System.out.println("9-회원수");
                    String numberOfUsers = controller.count();
                    System.out.println("회원수 "+numberOfUsers);
                    break;


            }

        }

    }
}