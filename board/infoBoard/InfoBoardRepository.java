package com.rod.api.board.infoBoard;

import com.rod.api.board.productBoard.ProductBoard;
import com.rod.api.common.AbstractRepository;
import com.rod.api.enums.messanger.Messenger;
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
    private PreparedStatement ps;
    private ResultSet rs;
    List<?> ls;

    private InfoBoardRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/roddb",
                "roddb",
                "roddb");
        ps = null;
        rs = null;
        this.ls = new ArrayList<>();
    }

    public List<?> findBoard() throws SQLException {
        String sql = "select * from InfoTable";
        ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();

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
        ps.close();

        return boardList;
    }

    public String quitRepository() throws SQLException {
        connection.close();
        return "연결이 종료되었습니다.";
    }

    @Override
    public Map<String, ?> save(Map<String, ?> paramMap) throws IOException {
        String sql = "";
        return null;
    }

    public Messenger createTable() throws SQLException {
        String sql
                = "CREATE TABLE IF NOT EXISTS InfoTable "
                + "(id INT PRIMARY KEY AUTO_INCREMENT, "
                + "title VARCHAR(20), "
                + "content VARCHAR(20), "
                + "writer VARCHAR(20), "
                + "date VARCHAR(20), "
                + "count VARCHAR(20)"
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
        String sql = "DROP TABLE IF EXISTS InfoTable";
        try {
            ps = connection.prepareStatement(sql);
            return ps.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e){
            System.err.println("SQL Exception Occurred");
            return Messenger.SQL_ERROR;
        }
    }
}
