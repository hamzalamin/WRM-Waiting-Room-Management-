package com.wora.wrm.repositories;

import com.wora.wrm.mappers.VisitMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<VisitMapper, Long> {
}
