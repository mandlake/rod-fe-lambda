package user;

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

        while (rs.next()) {
            System.out.printf("ID: %d, Title %s, Content: %s, Writer: %s\n",
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));
        }

        rs.close();
        statement.close();
        connection.close();

        return null;
    }
}