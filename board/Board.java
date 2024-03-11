package com.rod.api.board;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class Board {
    protected LocalDate date;
    protected String title;
    protected String content;
    protected String writer;
    protected String count;
}