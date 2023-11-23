package com.tjoeun.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjoeun.jpa.domain.MemberHistory;

public interface MemberHistoryRepository extends JpaRepository<MemberHistory, Long> {
	
	// memberId를 특정하여 특정 member에 대한 수정내역 데이터만 가져오는 쿼리 메소드를 만든다.
	List<MemberHistory> findByMemberId(Long memberId);
	
}
