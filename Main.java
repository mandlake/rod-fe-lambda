package com.rod.api;

import com.rod.api.enums.MainPage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            MainPage.goToPage(sc);
        }
    }
}