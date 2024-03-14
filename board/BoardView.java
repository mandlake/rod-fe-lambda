package com.rod.api.board;

import com.rod.api.enums.navigation.NavigationOfConsumer;

import java.sql.SQLException;
import java.util.Scanner;

public class BoardView {
    public static void boardView(Scanner sc) throws SQLException {
        while (true) {
            BoardRouter.execute(sc);
        }
    }

}