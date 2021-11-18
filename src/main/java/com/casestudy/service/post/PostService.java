package com.casestudy.service.post;

import com.casestudy.config.ConnectionSingleton;
import com.casestudy.model.Post;
import com.casestudy.service.user.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostService implements IPostService{
    Connection connection = ConnectionSingleton.getConnection();
    private final UserService userService = new UserService();

    @Override
    public void insert(Post post) throws SQLException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert  into post (tittle, content, image, user_id) value (?, ?, ?, ?)");
            preparedStatement.setString(1,post.getTittle());
            preparedStatement.setString(2,post.getContent());
            preparedStatement.setString(3, post.getImage());
            preparedStatement.setInt(4,post.getUser().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public int insertReturnId(Post post) throws SQLException {
        int postId = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert  into post (tittle, content, image, user_id) value (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,post.getTittle());
            preparedStatement.setString(2,post.getContent());
            preparedStatement.setString(3, post.getImage());
            preparedStatement.setInt(4,post.getUser().getId());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()){
                postId = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return postId;
    }

    @Override
    public Post findById(int id) {
        Post post = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from post where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String tittle = rs.getString("tittle");
                String content = rs.getString("content");
                String image = rs.getString("image");
                int user_id = rs.getInt("user_id");
               post = new Post(id, tittle,content, image, userService.findById(user_id));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return post;
    }

    @Override
    public boolean update(Post post) throws SQLException {
        boolean rowUpdate = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update post set tittle = ?, content = ?, image = ?, user_id = ? where id = ? ");
            preparedStatement.setString(1, post.getTittle());
            preparedStatement.setString(2, post.getContent());
            preparedStatement.setString(3, post.getImage());
            preparedStatement.setInt(4,post.getUser().getId());
            preparedStatement.setInt(5,post.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDelete = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from post where id = ?");
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public List<Post> findAll() {
        List<Post> postList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from post");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String tittle = rs.getString("tittle");
                String content = rs.getString("content");
                String image = rs.getString("image");
                int user_id = rs.getInt("user_id");
                postList.add(new Post(id, tittle,content,image,userService.findById(user_id)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return postList;
    }
}
