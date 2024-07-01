package com.wesleymartins.codigocerto.repositories;

import com.wesleymartins.codigocerto.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
