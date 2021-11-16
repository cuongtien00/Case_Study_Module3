package com.casestudy.service.relationship;

import com.casestudy.model.Relationship;

import java.sql.SQLException;
import java.util.List;

public class RelationshipService implements IRelationshipService{
    @Override
    public void insert(Relationship relationship) throws SQLException {

    }

    @Override
    public Relationship findById(int id) {
        return null;
    }

    @Override
    public boolean update(Relationship relationship) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public List<Relationship> findAll() {
        return null;
    }
}
