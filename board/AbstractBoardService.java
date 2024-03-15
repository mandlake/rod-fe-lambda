package com.rod.api.board;

import com.rod.api.common.AbstractService;
import com.rod.api.enums.messanger.Messenger;

import java.sql.SQLException;

public abstract class AbstractBoardService<T> extends AbstractService<T> {
    public abstract String quit() throws SQLException;
    public abstract Messenger createTable() throws SQLException;
    public abstract Messenger removeTable() throws SQLException;
}
