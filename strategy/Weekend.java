package com.rod.api.strategy;

import java.util.Scanner;

public class Weekend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String day = WeekendStrategy.execute(sc);
        System.out.println(day);
    }

    private static String execute(Scanner sc) {
        System.out.println("1 ~ 7 입력: ");
        String day = sc.next();
        return switch (day) {
            case "1" -> "Monday";
            case "2" -> "Tuesday";
            case "3" -> "Wednesday";
            case "4" -> "Thursday";
            case "5" -> "Friday";
            case "6" -> "Saturday";
            case "7" -> "Sunday";
            default -> "";
        };
    }
}