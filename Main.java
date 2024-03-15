package com.rod.api;

import com.rod.api.enums.messanger.Messenger;
import com.rod.api.enums.navigation.Navigation;
import com.rod.api.menu.Menu;
import com.rod.api.menu.MenuController;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println(Navigation.goToPage(sc));
        }
    }
}