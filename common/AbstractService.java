package com.rod.api.common;

import com.rod.api.enums.messanger.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T> {
    public abstract Messenger save(T t);
    public abstract List<T> findAll();
    public abstract Optional<T> findById(Long id);
    public abstract String count() throws SQLException;
    public abstract Optional<T> getOne(String id);
    public abstract String delete(T t);
    public abstract String deleteAll();
    public abstract Boolean existsById(Long id);


}