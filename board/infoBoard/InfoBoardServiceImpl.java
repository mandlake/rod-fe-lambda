package board.infoBoard;

import board.AbstractBoardService;
import enums.Messenger;
import lombok.Getter;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class InfoBoardServiceImpl extends AbstractBoardService<InfoBoard> implements InfoBoardService{

    @Getter
    private static InfoBoardServiceImpl instance = new InfoBoardServiceImpl();

    private static InfoBoardRepository repository;

    public InfoBoardServiceImpl() {
        repository = InfoBoardRepository.getInstance();
    }

    @Override
    public Messenger save(InfoBoard o) {
        return null;
    }

    @Override
    public List<InfoBoard> findAll() {
        return null;
    }

    @Override
    public Optional<InfoBoard> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() throws SQLException {
        return null;
    }

    @Override
    public Optional<InfoBoard> getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(InfoBoard o) {
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

    @Override
    public String quit() throws SQLException {
        return repository.quitRepository();
    }

    @Override
    public String createTable() throws SQLException {
        return repository.createTable();
    }

    @Override
    public String removeTable() throws SQLException {
        return repository.removeTable();
    }
}