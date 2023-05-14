package com.geekster.IntagramProject.repositories;

import com.geekster.IntagramProject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends CrudRepository<User,Long> {
    User findFirstByEmail(String email);
}
