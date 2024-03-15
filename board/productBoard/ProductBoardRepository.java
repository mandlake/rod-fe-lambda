package com.rod.api.board.productBoard;

import com.rod.api.board.AbstractBoardRepository;
import com.rod.api.enums.messanger.Messenger;
import lombok.Getter;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductBoardRepository extends AbstractBoardRepository {
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
    private PreparedStatement pstmt;
    private ResultSet rs;
    List<?> ls;

    private ProductBoardRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/roddb",
                "roddb",
                "roddb");
        this.ls = new ArrayList<>();
    }

    public List<?> findBoard() throws SQLException {
        String sql = "select * from ProductsTable";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();

        List<ProductBoard> boardList = new ArrayList<>();

        if(rs.next()){
            do {
                Long id =  rs.getLong("id");
                String title =  rs.getString("title");
                String content =  rs.getString("content");
                String writer =  rs.getString("writer");
                String count =  rs.getString("count");
                ProductBoard b = ProductBoard.builder()
                        .id(id)
                        .title(title)
                        .content(content)
                        .writer(writer)
                        .count(count)
                        .build();
                boardList.add(b);
            } while (rs.next());
        } else {
            System.out.println("데이터가 없습니다.");
        }

        ls = boardList;

        rs.close();
        statement.close();

        return boardList;
    }

    @Override
    public String quitRepository() throws SQLException {
        connection.close();
        return "연결이 종료되었습니다.";
    }

    @Override
    public Messenger createTable() throws SQLException {
        String sql
                = "CREATE TABLE IF NOT EXISTS ProductsTable "
                + "(id INT PRIMARY KEY AUTO_INCREMENT, "
                + "title VARCHAR(20), "
                + "content VARCHAR(20), "
                + "writer VARCHAR(20), "
                + "date VARCHAR(20), "
                + "count VARCHAR(20)"
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
        String sql = "DROP TABLE IF EXISTS ProductsTable";
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
}
