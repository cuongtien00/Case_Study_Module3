package com.casestudy.service.user;

import com.casestudy.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService{
    @Override
    public void insert(User user) throws SQLException {

    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public boolean update(User user) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
