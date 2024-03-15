package com.rod.api.menu;

import com.rod.api.enums.messanger.Messenger;
import lombok.Getter;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuRepository {
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
    private PreparedStatement ps;
    private ResultSet rs;

    private MenuRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/roddb",
                "roddb",
                "roddb");
    }

    public String quitRepository() throws SQLException {
        connection.close();
        return "연결이 종료되었습니다.";
    }

    public Messenger createTable() throws SQLException {
        String sql
                = "CREATE TABLE IF NOT EXISTS menus"
                + "(id BIGINT PRIMARY KEY AUTO_INCREMENT, "
                + "category VARCHAR(255), "
                + "item VARCHAR(255)"
                + ")";
        try {
            ps = connection.prepareStatement(sql);
            return ps.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred");
            return Messenger.SQL_ERROR;
        }
    }

    public Messenger removeTable() throws SQLException {
        String sql = "DROP TABLE IF EXISTS menus";
        try {
            ps = connection.prepareStatement(sql);
            return ps.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred");
            return Messenger.SQL_ERROR;
        }
    }

    public Map<String, ?> save(Map<String, ?> paramMap) throws IOException {
        return null;
    }

    public void insertMenu(Menu menu) {
        String sql = "INSERT INTO menus(category, item) VALUES(?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, menu.getCategory());
            ps.setString(2, menu.getItem());
            ps.executeUpdate();
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred :" + menu.getCategory() + " " + menu.getItem());
        }
    }

    public List<?> getMenusByCategory(String category){
        String sql = "SELECT m.item FROM menus m WHERE category = ?";
        List<Menu> menus = new ArrayList<>();
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, category);
            rs = ps.executeQuery();
            while(rs.next())
                menus.add(Menu.builder().item(rs.getString(1)).build());
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred");
            return menus;
        }
        return menus;
    }

    public Messenger returnMessenger() throws SQLException {
        String sql = "";
        ps = connection.prepareStatement(sql);

        return (ps.executeUpdate() == 0) ?
                Messenger.SUCCESS : Messenger.FAIL;
    }

    public Menu returnOneMenu() throws SQLException {
        String sql = "";
        ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();

        return Menu.builder().build();
    }

    public List<?> returnAllMenu() throws SQLException {
        String sql = "";
        ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();

        List<Menu> menus = new ArrayList<>();
        while (rs.next())
            menus.add(Menu.builder().build());

        return menus;
    }
}
