package com.rod.api.account;

import java.util.Scanner;

public class AccountView {
    public static void accountView(Scanner sc) {
        boolean account;
        do {
            account = AccountRouter.execute(sc);
        } while (account);
    }
}