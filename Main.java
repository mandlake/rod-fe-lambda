package com.rod.api;

import com.rod.api.enums.navigation.Navigation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println(Navigation.goToPage(sc));
        }
    }
}