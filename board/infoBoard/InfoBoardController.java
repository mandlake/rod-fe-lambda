package com.rod.api.board.infoBoard;

import com.rod.api.enums.messanger.Messenger;

import java.sql.SQLException;
import java.util.List;

public class InfoBoardController {
    InfoBoardServiceImpl service;

    public InfoBoardController() {
        this.service = InfoBoardServiceImpl.getInstance();
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

    public List<InfoBoard> getAll() {
        return service.findAll();
    }
}
