package com.casestudy.service.relationship;

import com.casestudy.config.ConnectionSingleton;
import com.casestudy.model.Relationship;
import com.casestudy.model.User;
import com.casestudy.service.user.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RelationshipService implements IRelationshipService{
    private final Connection connection = ConnectionSingleton.getConnection();
    private final  UserService userService = new UserService();
    @Override
    public void insert(Relationship relationship) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into relationship (receipt_id,send_id,status) value (?,?,?);");
        statement.setInt(1,relationship.getUser1().getId());
        statement.setInt(2,relationship.getUser2().getId());
        statement.setInt(3,relationship.getStatus());

        statement.executeQuery();



    }

    @Override
    public Relationship findById(int id) {
        Relationship relationship = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from relationship where id = ?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int receipt_id = resultSet.getInt("receipt_id");
                User user1 = userService.findById(receipt_id);
                int send_id = resultSet.getInt("send_id");
                User user2 = userService.findById(send_id);
                int status = resultSet.getInt("status");
                relationship = new Relationship(id,user1,user2,status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  relationship;

    }

    @Override
    public boolean update(Relationship relationship) throws SQLException {
       boolean rowUpdated;
       PreparedStatement statement = connection.prepareStatement("update relationship set receipt_id=?,send_id=?,status=? where id = ?;");
       statement.setInt(1,relationship.getUser1().getId());
       statement.setInt(2,relationship.getUser2().getId());
       statement.setInt(3,relationship.getStatus());
       statement.setInt(4,relationship.getId());

       rowUpdated = statement.executeUpdate()>0;
       return rowUpdated;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        PreparedStatement statement = connection.prepareStatement("delete from relationship where id=?;");
        statement.setInt(1,id);
        rowDeleted = statement.executeUpdate()>0;
        return rowDeleted;
    }

    @Override
    public List<Relationship> findAll() {
        List<Relationship> relationshipList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from relationship;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int receipt_id = resultSet.getInt("receipt_id");
                User user1 = userService.findById(receipt_id);
                int send_id = resultSet.getInt("send_id");
                User user2 = userService.findById(send_id);
                int status = resultSet.getInt("status");

                relationshipList.add(new Relationship(id,user1,user2,status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return relationshipList;

    }
}
