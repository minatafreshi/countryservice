package com.example.db.repository;

import com.example.db.entity.Country;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findByName(String name);
    Page<Country> findAll(Pageable pageable);
    List<Country> findAll();

    @Query(value="select c from Country c where (:ma is null or c.name like :ma) ")
    Page<Country> findByLike(@Param("ma") String ma, Pageable pageable);

}
