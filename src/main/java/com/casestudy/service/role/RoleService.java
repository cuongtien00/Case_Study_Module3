package com.casestudy.service.role;

import com.casestudy.model.Role;

import java.sql.SQLException;
import java.util.List;

public class RoleService implements IRoleService{
    @Override
    public void insert(Role role) throws SQLException {

    }

    @Override
    public Role findById(int id) {
        return null;
    }

    @Override
    public boolean update(Role role) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public List<Role> findAll() {
        return null;
    }
}
