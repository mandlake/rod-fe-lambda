package com.rod.api.menu;

import com.rod.api.enums.messanger.Messenger;

import java.sql.SQLException;
import java.util.List;

public interface MenuService {
    Messenger makeMenuTable() throws SQLException;

    Messenger removeTable() throws SQLException;

    List<?> getMenusByCategory(String category);
}
