package com.casestudy.service.user;

import com.casestudy.config.ConnectionSingleton;
import com.casestudy.model.Role;
import com.casestudy.model.User;
import com.casestudy.service.role.RoleService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService{
    private final Connection connection = ConnectionSingleton.getConnection();
    private final RoleService roleService = new RoleService();

    @Override
    public void insert(User user) throws SQLException {
        Connection connection = ConnectionSingleton.getConnection();

        PreparedStatement statement = connection.prepareStatement("insert into user (fullName,introduction,username,password,role_id) value (?,?,?,?,?);");
        statement.setString(1,user.getFullName());
        statement.setString(2,user.getIntroduction());
        statement.setString(3,user.getUserName());
        statement.setString(4,user.getPassWord());
        statement.setInt(5,1);
        statement.executeUpdate();
    }


    public boolean checkUserName(String username){
        boolean check = false;
        List<User> userList = findAll();
        for (User a:userList) {
            if(a.getUserName().equals(username)){
                check = true;
            }
        }
        return check;
    }
    @Override
    public User findById(int id) {
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from user where id=?;");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String fullName = resultSet.getString("fullName");
                String introduction = resultSet.getString("introduction");
                String username  = resultSet.getString("username");
                String password = resultSet.getString("password");
                int role_id = resultSet.getInt("role_id");
                Role role = roleService.findById(role_id);
                user = new User(id,fullName,introduction,username,password,role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean update(User user) throws SQLException {
        boolean rowUpdated;
        PreparedStatement statement = connection.prepareStatement("update user set fullName= ?, introduction = ?,username = ?, password=?, role_id=1 where id=?;");
        statement.setString(1,user.getFullName());
        statement.setString(2,user.getIntroduction());
        statement.setString(3,user.getUserName());
        statement.setString(4,user.getPassWord());
        statement.setInt(5,user.getId());

        rowUpdated = statement.executeUpdate()>0;
return rowUpdated;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        PreparedStatement statement = connection.prepareStatement("delete from user where  id=?");
        statement.setInt(1,id);
        rowDeleted = statement.executeUpdate()>0;
        return rowDeleted;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from user ");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String fullName = resultSet.getString("fullName");
               String introduction =  resultSet.getString("introduction");
               String username =  resultSet.getString("username");
                String password = resultSet.getString("password");
                int role_id = resultSet.getInt("role_id");
                Role role = roleService.findById(role_id);
                userList.add(new User(id,fullName,introduction,username,password,role));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
    public User findByIdPassword(String username,String password){
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from user where username = ? && password =?;");
            statement.setString(1,username);
            statement.setString(2,password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String fullName = resultSet.getString("fullName");
                String introduction = resultSet.getString("introduction");
                int role_id = resultSet.getInt("role_id");
                Role role = roleService.findById(role_id);
                user = new User(id,fullName,introduction,username,password,role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
//    public User isLogin(String username,String password){
//        User user = new User();
//        try {
//            PreparedStatement statement = connection.prepareStatement("select * from user where username = ? && password =?;");
//            statement.setString(1,username);
//            statement.setString(2,password);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()){
//                int id = resultSet.getInt("id");
//                String fullName = resultSet.getString("fullName");
//                String introduction = resultSet.getString("introduction");
//                int role_id = resultSet.getInt("role_id");
//                Role role = roleService.findById(role_id);
//                user = new User(id,fullName,introduction,username,password,role);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return user;
////        boolean check = false;
////        List<User>userList = findAll();
////        for (User a: userList) {
////            if(a.getUserName().equals(user.getUserName())&&a.getPassWord().equals(user.getPassWord())){
////                check = true;
////            }
////        }
////        return check;
//    }
}
