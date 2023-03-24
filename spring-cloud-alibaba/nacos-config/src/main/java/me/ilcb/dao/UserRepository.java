package me.ilcb.dao;

import me.ilcb.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface UserRepository extends CrudRepository<User, Long> {
}
