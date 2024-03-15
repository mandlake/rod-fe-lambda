package com.rod.api.account;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum AccountRouter {
    EXIT("x", sc -> false),
    CREATE("mk", sc -> {
        return true;
    }),
    INSERT("touch", sc -> {
        return true;
    }),
    WITHDRAW("with", sc -> {
        return true;
    }),
    DEPOSIT("depo", sc -> {
        return true;
    }),
    BALANCE("bal", sc -> {
        return true;
    }),
    REMOVE("rm", sc -> {
        return true;
    }),
    FIND("cat", sc -> {
        return true;
    }),
    LIST("ls-a", sc -> {
        return true;
    }),
    ERROR("error", sc-> {
        System.out.println("다시 입력해 주세요.");
        return true;
    });

    private final String s;
    private final Predicate<Scanner> predicate;

    AccountRouter(String s, Predicate<Scanner> predicate) {
        this.s = s;
        this.predicate = predicate;
    }

    public static Boolean execute(Scanner sc) {
        String s = sc.next();
        return Stream.of(values())
                .filter(o -> o.s.equals(s))
                .findFirst()
                .orElse(ERROR)
                .predicate.test(sc);
    }
}
