package com.rod.api.menu;

import com.rod.api.account.AccountController;
import com.rod.api.enums.messanger.Messenger;
import lombok.Getter;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MenuController extends AccountController {
    @Getter
    private static MenuController instance = new MenuController();

    MenuServiceImpl service;

    public MenuController() {
        this.service = MenuServiceImpl.getInstance();
    }


    public Messenger createTable() throws SQLException {
        return service.makeMenuTable();
    }

    public Messenger removeTable() throws SQLException {
        return service.removeTable();
    }

    public List<?> returnAllMenu() throws SQLException {
        return service.returnAllMenu();
    }

    public Messenger returnMessenger() throws SQLException {
        return service.returnMessenger();
    }

    public Menu returnOneMenu() throws SQLException {
        return service.returnOneMenu();
    }

    public List<?> returnAllNavigate(Scanner sc) throws SQLException {
        return service.getMenusByCategory("navigate");
    }
}
