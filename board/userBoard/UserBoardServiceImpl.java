package com.rod.api.board.userBoard;

import com.rod.api.board.AbstractBoardService;
import com.rod.api.enums.messanger.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserBoardServiceImpl extends AbstractBoardService<UserBoard> implements UserBoardService {
    @Override
    public String quit() throws SQLException {
        return null;
    }

    @Override
    public String createTable() throws SQLException {
        return null;
    }

    @Override
    public String removeTable() throws SQLException {
        return null;
    }

    @Override
    public Messenger save(UserBoard userBoard) {
        return null;
    }

    @Override
    public List<UserBoard> findAll() {
        return null;
    }

    @Override
    public Optional<UserBoard> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() throws SQLException {
        return null;
    }

    @Override
    public Optional<UserBoard> getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(UserBoard userBoard) {
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
