package com.geekster.IntagramProject.repositories;

import com.geekster.IntagramProject.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepo extends CrudRepository<Post,Integer> {
}
