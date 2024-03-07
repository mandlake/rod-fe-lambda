package board.productBoard;

import java.sql.SQLException;
import java.util.List;

public class ProductBoardController {

    ProductBoardServiceImpl service;

    public ProductBoardController() {
        this.service = ProductBoardServiceImpl.getInstance();
    }

    public List<?> getAll() throws SQLException {
        return service.getAll();
    }
}
