package com.wora.wrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Visitor extends JpaRepository<Visitor, Long> {
}
