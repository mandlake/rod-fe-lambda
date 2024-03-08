package board.infoBoard;

import board.productBoard.ProductBoard;
import common.AbstractRepository;
import lombok.Getter;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InfoBoardRepository extends AbstractRepository {

    @Getter
    private static InfoBoardRepository instance;

    static {
        try {
            instance = new InfoBoardRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private final Connection connection;
    List<?> ls;

    private InfoBoardRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/roddb",
                "roddb",
                "roddb");
        this.ls = new ArrayList<>();
    }

    public List<?> findBoard() throws SQLException {
        String sql = "select * from InfoTable";
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

    public String quitRepository() throws SQLException {
        connection.close();
        return "연결이 종료되었습니다.";
    }

    @Override
    public Map<String, ?> save(Map<String, ?> paramMap) throws IOException {
        return null;
    }

    public String createTable() throws SQLException {
        String createTableQuery
                = "CREATE TABLE IF NOT EXISTS InfoTable "
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

    public String removeTable() throws SQLException {
        String dropTableQuery = "DROP TABLE IF EXISTS InfoTable";
        PreparedStatement ps = connection.prepareStatement(dropTableQuery);
        ps.executeUpdate();
        ps.close();
        return "테이블이 삭제되었습니다.";
    }
}
