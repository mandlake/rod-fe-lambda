package com.rod.api.menu;

import com.rod.api.account.AccountController;
import com.rod.api.enums.messanger.Messenger;
import lombok.Getter;

import java.sql.SQLException;

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
}
