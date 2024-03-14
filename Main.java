package com.rod.api;

import com.rod.api.enums.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println(Navigation.goToPage(sc));
            System.out.println(NavigationOfSupply.goToPage(sc));
            System.out.println(NavigationOfFunction.goToPage(sc));
            NavigationOfConsumer.goToPage(sc);
            System.out.println(NavigationOfPredicate.navigate(sc));
        }
    }
}