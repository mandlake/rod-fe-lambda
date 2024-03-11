package com.rod.api.board.productBoard;

import com.rod.api.board.Board;
import lombok.*;

import java.time.LocalDate;
import java.time.ZoneId;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class ProductBoard extends Board {
    private Long id;

    @Builder(builderMethodName = "builder")
    public ProductBoard(Long id, String title, String content, String writer, String count) {
        this.id = id;
        this.date = LocalDate.now(ZoneId.of("Korea/Seoul"));
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.count = count;
    }
}
