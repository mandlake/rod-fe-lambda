package com.rod.api.board.productBoard;

import com.rod.api.enums.messanger.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductBoardController {

    ProductBoardServiceImpl service;

    public ProductBoardController() {
        this.service = ProductBoardServiceImpl.getInstance();
    }

    public List<?> getAll() throws SQLException {
        return service.getAll();
    }

    public String getOne(Scanner sc) throws SQLException {
        return service.getOne(sc.nextInt());
    }

    public String count() throws SQLException {
        return service.count();
    }

    public String quit() throws SQLException {
        return service.quit();
    }

    public Messenger createTable() throws SQLException {
        return service.createTable();
    }

    public Messenger removeTable() throws SQLException {
        return service.removeTable();
    }
}
