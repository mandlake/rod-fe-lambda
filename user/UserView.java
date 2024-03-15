package com.rod.api.user;

import java.sql.SQLException;
import java.util.Scanner;



public class UserView {
    public static void userView(Scanner sc) throws SQLException {
        boolean router;
        do {
            router = UserRouter.execute(sc);
        }
        while (router);
    }
}