package board.infoBoard;

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

    public String createTable() throws SQLException {
        return service.createTable();
    }

    public String removeTable() throws SQLException {
        return service.removeTable();
    }

    public List<InfoBoard> getAll() {
        return service.findAll();
    }
}
