package com.example.db.repository;

import com.example.db.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findByName(String Name);
    List<City> findAll();

    @Query(value = "select c from City c where c.state.id = :id")
    List<City> listByStateId(@Param("id") Long id);
}
