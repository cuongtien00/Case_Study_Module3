package com.casestudy.service.role;

import com.casestudy.config.ConnectionSingleton;
import com.casestudy.model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleService implements IRoleService{
//    public static void main(String[] args) {
//        RoleService roleService = new RoleService();
//        Role role = new Role(1,"Local");
//        roleService.update(role);
//
//    }

    @Override
    public void insert(Role role){
        Connection connection = ConnectionSingleton.getConnection();
        try {
            PreparedStatement statement= connection.prepareStatement("insert into role(id,name) values (?,?)");
            statement.setInt(1,role.getId());
            statement.setString(2,role.getName());
            int rowInserted =statement.executeUpdate();
            System.out.println(rowInserted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Role findById(int id) {
        Role role = null;
        Connection connection = ConnectionSingleton.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from role where id = ?");
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                role = new Role(id,name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public boolean update(Role role) {
        boolean rowUpdate = false;
        Connection connection = ConnectionSingleton.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("update role set name =? where id=?");
            statement.setString(1, role.getName());
            statement.setInt(2, role.getId());
            statement.executeUpdate();
            rowUpdate=statement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowUpdate;
    }

    @Override
    public boolean delete(int id)  {
        boolean rowDelete = false;
        Connection connection = ConnectionSingleton.getConnection();

        try {
            PreparedStatement  statement = connection.prepareStatement("delete from role where id=?");
            statement.setInt(1,id);
            rowDelete = statement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowDelete;
    }

    @Override
    public List<Role> findAll() {
        List<Role> roleList = new ArrayList<>();
        Connection connection = ConnectionSingleton.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from role");
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id =rs.getInt("id");
                String name = rs.getString("name");
                roleList.add(new Role(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roleList;
    }
}
