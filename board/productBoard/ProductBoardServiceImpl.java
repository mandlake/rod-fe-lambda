package board.productBoard;

import lombok.Getter;

import java.sql.SQLException;
import java.util.List;

public class ProductBoardServiceImpl implements ProductBoardService {

    @Getter
    private static ProductBoardServiceImpl instance = new ProductBoardServiceImpl();
    private ProductBoardRepository repository;

    public ProductBoardServiceImpl() {
        repository = ProductBoardRepository.getInstance();
    }

    @Override
    public List<?> getAll() throws SQLException {
        return repository.findBoard();
    }
}
