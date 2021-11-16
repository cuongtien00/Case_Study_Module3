package com.casestudy.service.post;

import com.casestudy.model.Post;

import java.sql.SQLException;
import java.util.List;

public class PostService implements IPostService{
    @Override
    public void insert(Post post) throws SQLException {

    }

    @Override
    public Post findById(int id) {
        return null;
    }

    @Override
    public boolean update(Post post) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public List<Post> findAll() {
        return null;
    }
}
