package com.casestudy.service.likepost;

import com.casestudy.config.ConnectionSingleton;
import com.casestudy.model.LikePost;
import com.casestudy.service.IService;
import com.casestudy.service.post.PostService;
import com.casestudy.service.user.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LikePostService implements ILikePostService {
    private final PostService postService = new PostService();
    private final UserService userService = new UserService();
    Connection connection = ConnectionSingleton.getConnection();
    @Override
    public void insert(LikePost likePost) throws SQLException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into likepost (post_id, user_id) value (?, ?)");
            preparedStatement.setInt(1,likePost.getPost().getId());
            preparedStatement.setInt(2,likePost.getUser().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public LikePost findById(int id) {
        LikePost likePost = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from likepost where id = ?");
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int post_id = rs.getInt("post_id");
                int user_id = rs.getInt("user_id");
                likePost = new LikePost(id,postService.findById(post_id),userService.findById(user_id));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return likePost;
    }

    @Override
    public boolean update(LikePost likePost) throws SQLException {
        boolean rowUpdate = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update likepost set post_id = ?, user_id = ? where id = ?");
            preparedStatement.setInt(1,likePost.getPost().getId());
            preparedStatement.setInt(2,likePost.getUser().getId());
            preparedStatement.setInt(3,likePost.getId());
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
            PreparedStatement preparedStatement = connection.prepareStatement("delete from likepost where id = ?");
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public List<LikePost> findAll() {
        List<LikePost> likePostList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from likepost");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int post_id = rs.getInt("post_id");
                int user_id = rs.getInt("user_id");
                likePostList.add(new LikePost(id, postService.findById(post_id),userService.findById(user_id)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return likePostList;
    }public List<LikePost> findAllByPostId(int postId) {
        List<LikePost> likePostList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from likepost where post_id=?");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int post_id = rs.getInt("post_id");
                int user_id = rs.getInt("user_id");
                likePostList.add(new LikePost(id, postService.findById(post_id),userService.findById(user_id)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return likePostList;
    }
}
