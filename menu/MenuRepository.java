package com.rod.api.menu;

import com.rod.api.board.AbstractBoardRepository;
import com.rod.api.enums.messanger.Messenger;
import lombok.Getter;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
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
    private PreparedStatement pstmt;
    private ResultSet rs;

    private MenuRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/roddb",
                "roddb",
                "roddb");
    }

    public List<?> findUsers() throws SQLException {
        String sql = "select * from menu";
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
    public Messenger createTable() throws SQLException {
        String sql
                = "CREATE TABLE IF NOT EXISTS menus"
                + "(id BIGINT PRIMARY KEY AUTO_INCREMENT, "
                + "category VARCHAR(255), "
                + "item VARCHAR(255)"
                + ")";
        try {
            pstmt = connection.prepareStatement(sql);
            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred");
            return Messenger.SQL_ERROR;
        }
    }

    @Override
    public Messenger removeTable() throws SQLException {
        String sql = "DROP TABLE IF EXISTS menus";
        try {
            pstmt = connection.prepareStatement(sql);
            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred");
            return Messenger.SQL_ERROR;
        }
    }

    @Override
    public Map<String, ?> save(Map<String, ?> paramMap) throws IOException {
        return null;
    }

    public void insertMenu(Menu menu) {
        String sql = "INSERT INTO menus(category, item) VALUES(?,?)";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, menu.getCategory());
            pstmt.setString(2, menu.getItem());
            pstmt.executeUpdate();
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred :" + menu.getCategory() + " " + menu.getItem());
        }
    }

    public List<?> getMenusByCategory(String category){
        String sql = "SELECT m.item FROM menus m WHERE category = ?";
        List<Menu> menus = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, category);
            rs = pstmt.executeQuery();
            while(rs.next())    menus.add(Menu.builder().item(rs.getString(1)).build());
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred");
            return menus;
        }
        return menus;
    }
}
