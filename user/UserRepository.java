package user;

import java.sql.*;

public class UserRepository {
    public void findUsers() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/roddb";
        String userName = "roddb";
        String password = "roddb";

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from board");

        resultSet.next();
        String name = resultSet.getString("name");
        System.out.println(name);

        resultSet.close();
        statement.close();
        connection.close();
    }
}