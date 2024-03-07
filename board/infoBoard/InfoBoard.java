package board.infoBoard;

import board.Board;
import lombok.*;

import java.time.LocalDate;
import java.time.ZoneId;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class InfoBoard extends Board {
    private Long id;
    @Builder(builderMethodName = "builder")
    public InfoBoard(Long id, String title, String content, String writer, int count) {
        this.id = id;
        date = LocalDate.now(ZoneId.of("Korea/Seoul"));
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.count = count;
    }
}
