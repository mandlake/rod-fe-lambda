package user;

import java.util.Scanner;

public class UserController {

    UserServiceImpl userService;

    public UserController() {
        this.userService = UserServiceImpl.getInstance();
    }

    public String addUsers() {
        String msg = userService.addUsers();
        return msg;
    }

    public String join(Scanner sc) {
        System.out.println("ID, " +
                "비밀번호, " +
                "이름, " +
                "주민번호, " +
                "전화번호, " +
                "주소, " +
                "직업을 입력해주세요");
        return userService.join(User.builder()
                .username(sc.next())
                .password(sc.next())
                .name(sc.next())
                .ssn(sc.next())
                .phoneNumber(sc.next())
                .address(sc.next())
                .job(sc.next())
                .build());
    }
}