package com.example.db.repository;

import com.example.db.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
    Optional<State> findByName(String name);
    List<State> findAll();
}
