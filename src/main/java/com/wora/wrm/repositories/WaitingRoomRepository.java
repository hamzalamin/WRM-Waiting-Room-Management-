package com.wora.wrm.repositories;

import com.wora.wrm.models.entities.WaitingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaitingRoomRepository extends JpaRepository<WaitingRoom, Long> {
}
