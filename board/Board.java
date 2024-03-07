package board;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class Board {
    private Long id;
    protected LocalDate date;
    protected String title;
    protected String content;
    protected String writer;
    protected int count;
}