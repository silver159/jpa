package com.tjoeun.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjoeun.jpa.domain.MemberHistory;

public interface MemberHistoryRepository extends JpaRepository<MemberHistory, Long> {
	
}
