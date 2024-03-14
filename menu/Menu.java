package com.rod.api.menu;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"id"})
public class Menu {
    private Long id;
    private String item;
    private String category;

    @Builder(builderMethodName = "builder")
    public Menu(Long id, String item, String category) {
        this.id = id;
        this.item = item;
        this.category = category;
    }
}
