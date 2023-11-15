package com.tjoeun.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tjoeun.jpa.domain.Member;

// @SpringBootTest 어노테이션을 붙여서 테스트 클래스임을 springBoot에게 알려준다.
@SpringBootTest
class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	public void crud() {
		Member member = new Member("홍길동", "a@a.com");
		memberRepository.save(member);
		
//		System.err.println(memberRepository.findAll());
		// 여러 줄로 출력한다.
//		for (Member m : memberRepository.findAll()) {
//			System.out.println(m);
//		}
		// 람다식을 사용해서 여러 줄로 출력한다.
		memberRepository.findAll().forEach(System.out::println);
	}
		
	
}
