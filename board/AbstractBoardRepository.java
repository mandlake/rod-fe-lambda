package com.rod.api.board;

import com.rod.api.common.AbstractRepository;
import com.rod.api.enums.messanger.Messenger;

import java.sql.SQLException;
import java.util.List;

public abstract class AbstractBoardRepository extends AbstractRepository {
    public abstract List<?> findBoard() throws SQLException;
    public abstract String quitRepository() throws SQLException;
    public abstract Messenger createTable() throws SQLException;
    public abstract Messenger removeTable() throws SQLException;
}
