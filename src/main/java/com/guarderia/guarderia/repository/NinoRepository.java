package com.guarderia.guarderia.repository;

import com.guarderia.guarderia.entity.Nino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinoRepository extends JpaRepository<Nino, Long> {
}
    