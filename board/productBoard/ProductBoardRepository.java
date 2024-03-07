package board.productBoard;

import lombok.Getter;

import java.sql.*;
import java.util.List;

public class ProductBoardRepository {
    @Getter
    private static ProductBoardRepository instance;

    static {
        try {
            instance = new ProductBoardRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private final Connection connection;

    private ProductBoardRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/roddb",
                "roddb",
                "roddb");
    }

    public List<?> findBoard() throws SQLException {
        String sql = "select * from boards";
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
