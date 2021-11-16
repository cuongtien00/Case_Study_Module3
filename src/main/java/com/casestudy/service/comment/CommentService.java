package com.casestudy.service.comment;

import com.casestudy.model.Comment;

import java.sql.SQLException;
import java.util.List;

public class CommentService implements ICommentService{
    @Override
    public void insert(Comment comment) throws SQLException {

    }

    @Override
    public Comment findById(int id) {
        return null;
    }

    @Override
    public boolean update(Comment comment) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public List<Comment> findAll() {
        return null;
    }
}
