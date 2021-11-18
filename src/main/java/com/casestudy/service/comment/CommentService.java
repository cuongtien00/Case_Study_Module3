package com.casestudy.service.comment;

import com.casestudy.config.ConnectionSingleton;
import com.casestudy.model.Comment;
import com.casestudy.model.Post;
import com.casestudy.model.User;
import com.casestudy.service.post.PostService;
import com.casestudy.service.user.UserService;

import javax.servlet.RequestDispatcher;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentService implements ICommentService{

    Connection connection = ConnectionSingleton.getConnection();
    private PostService postService = new PostService();
    private UserService userService = new UserService();

    @Override
    public List<Comment> findAll() {
        List<Comment> commentList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from comment");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String content = rs.getString("content");
                int post_id = rs.getInt("post_id");
                Post post = postService.findById(post_id);
                int user_id = rs.getInt("user_id");
                User user = userService.findById(user_id);
                Comment comment = new Comment(id, content, post, user);
                commentList.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commentList;
    }



    @Override
    public void insert(Comment comment)  {
        try{
            PreparedStatement ps = connection.prepareStatement("insert into comment(content, post_id, user_id) value (?,?,?)");
            ps.setString(1, comment.getContent());
            ps.setInt(2, comment.getPost().getId());
            ps.setInt(3, comment.getUser().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }public int insertReturnId(Comment comment)  {
        int commentId= 0;
        try{
            PreparedStatement ps = connection.prepareStatement("insert into comment(content, post_id, user_id) value (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, comment.getContent());
            ps.setInt(2, comment.getPost().getId());
            ps.setInt(3, comment.getUser().getId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()){
                commentId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commentId;
    }

    @Override
    public Comment findById(int id) {
        Comment comment = null;
        try {
            PreparedStatement ps = connection.prepareStatement("select from comment where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String content = rs.getString("content");
                int post_id = rs.getInt("post_id");
                Post post = postService.findById(post_id);
                int user_id = rs.getInt("user_id");
                User user = userService.findById(user_id);
                comment = new Comment(id, content, post, user);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comment;
    }

    @Override
    public boolean update(Comment comment) throws SQLException {
        boolean rowUpdate = false;
        try {
            PreparedStatement ps = connection.prepareStatement("update comment set content=?, post_id=?, user_id=? where id=?");
            ps.setString(1, comment.getContent());
            ps.setInt(2, comment.getPost().getId());
            ps.setInt(3, comment.getUser().getId());
            ps.setInt(4, comment.getId());
            rowUpdate = ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDelete = false;
        try {
            PreparedStatement ps = connection.prepareStatement("delete from comment where id=?");
            ps.setInt(1, id);
            rowDelete = ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }
}
