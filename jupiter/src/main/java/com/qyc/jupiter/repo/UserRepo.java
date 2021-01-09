package com.qyc.jupiter.repo;

import com.qyc.jupiter.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findOptionalByUsername(String username);
    Stream<User> findByAgeGreaterThan(Integer age);
}
