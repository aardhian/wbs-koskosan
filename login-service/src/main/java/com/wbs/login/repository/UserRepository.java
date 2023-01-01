package com.wbs.login.repository;

import com.wbs.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByUsernameAndPassword(String username, String password);
}
