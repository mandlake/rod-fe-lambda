package com.rod.api.board.productBoard;

import com.rod.api.board.AbstractBoardRepository;
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
    public String createTable() throws SQLException {
        String createTableQuery
                = "CREATE TABLE IF NOT EXISTS ProductsTable "
                + "(id INT PRIMARY KEY AUTO_INCREMENT, "
                + "title VARCHAR(20), "
                + "content VARCHAR(20), "
                + "writer VARCHAR(20), "
                + "date VARCHAR(20), "
                + "count VARCHAR(20)"
                + ")";
        PreparedStatement ps = connection.prepareStatement(createTableQuery);
        ps.executeUpdate();
        ps.close();
        return "테이블이 생성되었습니다.";
    }

    @Override
    public String removeTable() throws SQLException {
        String dropTableQuery = "DROP TABLE IF EXISTS ProductsTable";
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
