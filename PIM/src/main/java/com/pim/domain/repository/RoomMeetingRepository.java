package com.pim.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pim.domain.entity.meeting;

@Repository
public interface RoomMeetingRepository extends JpaRepository<meeting, Integer> {

}
