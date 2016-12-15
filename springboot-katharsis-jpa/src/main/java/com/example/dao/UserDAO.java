package com.example.dao;

import com.example.model.UsersEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDAO extends PagingAndSortingRepository<UsersEntity, Integer> {

}
