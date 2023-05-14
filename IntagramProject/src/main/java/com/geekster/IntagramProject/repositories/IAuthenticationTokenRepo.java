package com.geekster.IntagramProject.repositories;

import com.geekster.IntagramProject.models.AuthenticationToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationTokenRepo extends CrudRepository<AuthenticationToken,Long> {
}
