package board;

import common.AbstractRepository;

import java.sql.SQLException;
import java.util.List;

public abstract class AbstractBoardRepository extends AbstractRepository {
    public abstract List<?> findBoard() throws SQLException;
    public abstract String quitRepository() throws SQLException;
    public abstract String createTable() throws SQLException;
    public abstract String removeTable() throws SQLException;
}
