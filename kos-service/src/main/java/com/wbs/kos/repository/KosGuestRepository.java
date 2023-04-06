package com.wbs.kos.repository;

import com.wbs.kos.model.KosGuest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KosGuestRepository extends JpaRepository<KosGuest, Long> {
}
