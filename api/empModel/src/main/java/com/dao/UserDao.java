package com.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.models.User;

@Repository
@Qualifier("userDao")
public interface UserDao extends MongoRepository<User, String> {

}
