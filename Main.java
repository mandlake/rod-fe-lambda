package com.rod.api;

import com.rod.api.enums.MainPage;

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

            MainPage.goToPage(sc.next(), sc);
        }
    }
}