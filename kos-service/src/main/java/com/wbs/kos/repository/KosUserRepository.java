package com.wbs.kos.repository;

import com.wbs.kos.model.KosUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KosUserRepository extends JpaRepository<KosUser, Long> {
    KosUser findByUsernameAndActiveTrue(String username);
}
