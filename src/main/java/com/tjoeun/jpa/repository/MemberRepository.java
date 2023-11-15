package com.tjoeun.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjoeun.jpa.domain.Member;

// 특정 entity(테이블)에서 JPA로 sql 명령을 실행하려면 JpaRepository 인터페이스를 상속받아
// Repository 인터페이스를 만들어야 한다.
// JpaRepository<@entity 어노테이션을 붙여준 클래스, 기본키 필드 자료형>
public interface MemberRepository extends JpaRepository<Member, Long> {
	
}
