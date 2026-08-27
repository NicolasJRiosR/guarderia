package com.guarderia.guarderia.repository;

import com.guarderia.guarderia.entity.ResponsableNino;
import com.guarderia.guarderia.entity.ResponsableNinoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsableNinoRepository extends JpaRepository<ResponsableNino, ResponsableNinoId> {
}
