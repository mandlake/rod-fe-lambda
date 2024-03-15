package com.rod.api;

import com.rod.api.enums.navigation.Navigation;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        boolean nav;

        do {
            nav = Navigation.goToPage(sc);
        } while (nav);
    }
}