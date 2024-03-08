package board.productBoard;

import java.sql.SQLException;
import java.util.List;

public interface ProductBoardService {
    List<?> getAll() throws SQLException;

    String getOne(int i) throws SQLException;
}
