package com.rod.api.user;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.*;
import java.util.stream.Stream;

public enum UserRouter {
    EXIT("x", sc -> {
        return false;
    }),
    JOIN("j", sc -> {
        System.out.println("회원가입");
        System.out.println("ID, 비밀번호, 이름, 주민번호," +
                " 전화번호, 주소, 직업을 입력해주세요");
        System.out.println("회원가입 결과 : "
                + UserController.getInstance().save(sc));
        return true;
    }),
    LOGIN("l", sc -> {
        System.out.println("로그인");
        System.out.println("아이디와 비밀번호를 입력하세요.");
        System.out.println("로그인 결과 : "
                + UserController.getInstance().login(sc));
        return true;
    }),
    ID("id", sc -> {
        System.out.println("ID 검색");
        System.out.println("검색할 아이디를 입력하세요.");
        System.out.println(UserController.getInstance().getOne(sc));
        return true;
    }),
    PASSWORD("pw", sc -> {
        System.out.println("비번변경");
        System.out.println("아이디와 비밀번호를 입력하세요.");
        System.out.println(UserController.getInstance().updatePassword(sc));
        return true;
    }),
    DELETE("e", sc -> {
        System.out.println("탈퇴");
        System.out.println("아이디를 입력하세요.");
        System.out.println(UserController.getInstance().delete(sc));
        return true;
    }),
    LIST("ls", sc -> {
        System.out.println("회원목록");
        try {
            UserController.getInstance().getUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    NAME("n", sc -> {
        System.out.println("이름검색");
        System.out.println("이름을 입력하세요.");
        UserController.getInstance()
                .findUsersByName(sc)
                .forEach(System.out::println);
        return true;
    }),
    JOB("j", sc -> {
        System.out.println("직업검색");
        System.out.println("직업을 입력하세요.");
        UserController.getInstance()
                .findUsersByJob(sc)
                .forEach(System.out::println);
        return true;
    }),
    COUNT("c", sc -> {
        System.out.println("회원수");
        String numberOfUsers = UserController.getInstance().count();
        System.out.println("회원수 "+numberOfUsers);
        return true;
    }),
    MAKE("mk", sc -> {
        System.out.println("테이블생성");
        return true;
    }),
    REMOVE("rm", sc -> {
        System.out.println("테이블삭제");
        return true;
    }),
    INSERT("in", sc -> {
        System.out.println("아이템삽입");
        return true;
    }),
    ERROR("error", sc-> {
        System.out.println("다시 입력해 주세요.");
        return true;
    });
    private final String s;
    private final Predicate<Scanner> predicate;

    UserRouter(String s, Predicate<Scanner> predicate) {
        this.s = s;
        this.predicate = predicate;
    }

    public static Boolean execute(Scanner sc) {
        System.out.println("[사용자메뉴] x-종료 j-회원가입 l-로그인 id-ID검색 pw-비번변경 e-탈퇴 ls-회원목록 " +
                "n-이름검색 j-직업검색 c-회원수 mk-테이블생성 rm-테이블삭제 in-아이템삽입");
        String s = sc.next();
        return Stream.of(values())
                .filter(o -> o.s.equals(s))
                .findFirst()
                .orElse(ERROR)
                .predicate.test(sc);
    }
}
