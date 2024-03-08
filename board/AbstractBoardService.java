package board;

import common.AbstractService;

import java.sql.SQLException;

public abstract class AbstractBoardService<T> extends AbstractService<T> {
    public abstract String quit() throws SQLException;
    public abstract String createTable() throws SQLException;
    public abstract String removeTable() throws SQLException;
}
