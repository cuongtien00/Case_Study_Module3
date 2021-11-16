package com.casestudy.service.likepost;

import com.casestudy.model.LikePost;
import com.casestudy.service.IService;

import java.sql.SQLException;
import java.util.List;

public class LikePostService implements ILikePostService {
    @Override
    public void insert(LikePost likePost) throws SQLException {

    }

    @Override
    public LikePost findById(int id) {
        return null;
    }

    @Override
    public boolean update(LikePost likePost) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public List<LikePost> findAll() {
        return null;
    }
}
