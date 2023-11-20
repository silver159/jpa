package com.tjoeun.jpa.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import lombok.Builder;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j // 롬복에서 지원하는 로그를 사용할 수 있게한다.
class MemberTest {

	@Test
	void test() {
		Member member = new Member();
		member.setName("홍길동");
		member.setEmail("a@a.com");
		member.setCreateAt(LocalDateTime.now());
		member.setUpdateAt(LocalDateTime.now());
		System.out.println("member: "+ member);
		log.info("member: {}", member); // 문자열만 가능
		
		
//		Member member2 = new Member(1L, "임꺽정", "b@b.com", LocalDateTime.now(), LocalDateTime.now());
//		System.out.println("member2: "+ member2);
		Member member3 = new Member("장길산", "c@c.com");
		System.out.println("member3: "+ member3);
		
		// 클래스에 @Builder 어노테이션을 붙여주면 아래와 같이 객체를 생성할 수 있다.
		// 단, 생성자가 준비안된 경우에는 실행이 안된다.
		// Member member4 = Member.builder().name("일지매").build(); // 실행이 안된다.
		Member member4 = Member.builder().name("일지매").email("d@d.com").build(); // 생성자가 있어야 생성
		System.out.println("member4: "+ member4);
	}
}
