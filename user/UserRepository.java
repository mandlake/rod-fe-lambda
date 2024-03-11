package com.rod.api.user;

import lombok.Getter;

import java.sql.*;
import java.util.List;

public class UserRepository {
    @Getter
    private static UserRepository instance;

    static {
        try {
            instance = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final Connection connection;

    private UserRepository() throws SQLException {
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
                System.out.printf("ID: %d, Title %s, Content: %s, Writer: %s\n",
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("writer"));
            } while (rs.next());
        } else {
            System.out.println("데이터가 없습니다.");
        }

        rs.close();
        statement.close();

        return null;
    }

    public String quitRepository() throws SQLException {
        connection.close();
        return "연결이 종료되었습니다.";
    }
}