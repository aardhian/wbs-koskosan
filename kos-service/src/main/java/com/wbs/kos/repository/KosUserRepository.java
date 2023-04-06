package com.wbs.kos.repository;

import com.wbs.kos.model.KosUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KosUserRepository extends JpaRepository<KosUser, Long> {
    KosUser findByUsernameAndActiveTrue(String username);
}
