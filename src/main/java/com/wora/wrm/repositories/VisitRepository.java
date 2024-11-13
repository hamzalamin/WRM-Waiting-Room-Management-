package com.wora.wrm.repositories;

import com.wora.wrm.models.entities.Visit;
import com.wora.wrm.models.entities.embeddables.VisitorWaitingRoomId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, VisitorWaitingRoomId> {
}
