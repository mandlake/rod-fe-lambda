package com.rod.api.menu;

import com.rod.api.board.AbstractBoardRepository;
import lombok.Getter;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Map;

public class MenuRepository extends AbstractBoardRepository {
    @Getter
    private static MenuRepository instance;

    static {
        try {
            instance = new MenuRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final Connection connection;

    private MenuRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/roddb",
                "roddb",
                "roddb");
    }

    public List<?> findUsers() throws SQLException {
        String sql = "select * from board";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();

        if(rs.next()){
            do {
                System.out.printf("ID: %d, Item: %s, Category: %s\n",
                        rs.getLong("id"),
                        rs.getString("item"),
                        rs.getString("category"));
            } while (rs.next());
        } else {
            System.out.println("데이터가 없습니다.");
        }

        rs.close();
        statement.close();

        return null;
    }

    @Override
    public List<?> findBoard() throws SQLException {
        return null;
    }

    public String quitRepository() throws SQLException {
        connection.close();
        return "연결이 종료되었습니다.";
    }

    @Override
    public String createTable() throws SQLException {
        String createTableQuery
                = "CREATE TABLE IF NOT EXISTS Menu "
                + "(id BIGINT PRIMARY KEY AUTO_INCREMENT, "
                + "item VARCHAR(255), "
                + "category VARCHAR(255)"
                + ")";
        PreparedStatement ps = connection.prepareStatement(createTableQuery);
        ps.executeUpdate();
        ps.close();
        return "테이블이 생성되었습니다.";
    }

    @Override
    public String removeTable() throws SQLException {
        String dropTableQuery = "DROP TABLE IF EXISTS Menu";
        PreparedStatement ps = connection.prepareStatement(dropTableQuery);
        ps.executeUpdate();
        ps.close();
        return "테이블이 삭제되었습니다.";
    }

    @Override
    public Map<String, ?> save(Map<String, ?> paramMap) throws IOException {
        return null;
    }
}
