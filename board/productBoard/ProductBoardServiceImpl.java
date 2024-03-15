package com.rod.api.board.productBoard;

import com.rod.api.board.AbstractBoardService;
import com.rod.api.enums.messanger.Messenger;
import lombok.Getter;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductBoardServiceImpl extends AbstractBoardService<ProductBoard> implements ProductBoardService {

    @Getter
    private static ProductBoardServiceImpl instance = new ProductBoardServiceImpl();
    private final ProductBoardRepository repository;

    public ProductBoardServiceImpl() {
        repository = ProductBoardRepository.getInstance();
    }

    @Override
    public List<?> getAll() throws SQLException {
        return repository.findBoard();
    }

    @Override
    public String getOne(int i) throws SQLException {
        List<?> board = repository.findBoard();
        return board.get(i) == null ?
                "해당 페이지가 없습니다." : board.get(i) + "";
    }

    @Override
    public Messenger createTable() throws SQLException {
        return repository.createTable();
    }

    @Override
    public Messenger removeTable() throws SQLException {
        return repository.removeTable();
    }

    @Override
    public String quit() throws SQLException {
        return repository.quitRepository();
    }

    @Override
    public Messenger save(ProductBoard o) {
        return null;
    }

    @Override
    public List<ProductBoard> findAll() {
        return null;
    }

    @Override
    public Optional<ProductBoard> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() throws SQLException {
        List<?> board = repository.findBoard();
        return board.size() + "";
    }

    @Override
    public Optional<ProductBoard> getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(ProductBoard o) {
        return null;
    }

    @Override
    public String deleteAll() {
        return null;
    }

    @Override
    public Boolean existsById(Long id) {
        return null;
    }
}
