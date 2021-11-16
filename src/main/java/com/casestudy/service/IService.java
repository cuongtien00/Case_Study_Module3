package com.casestudy.service;

import java.sql.SQLException;
import java.util.List;

public interface IService<T> {
    void insert(T t)throws SQLException;
    T findById(int id);
    boolean update(T t)throws SQLException;
    boolean delete(int id)throws SQLException;
    List<T> findAll();
}
