package com.pim.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pim.domain.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

}
