package com.tjoeun.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tjoeun.jpa.domain.Member;

// 특정 entity(테이블)에서 JPA로 sql 명령을 실행하려면 JpaRepository 인터페이스를 상속받아
// Repository 인터페이스를 만들어야 한다.
// JpaRepository<@entity 어노테이션을 붙여준 클래스, 기본키 필드 자료형>
public interface MemberRepository extends JpaRepository<Member, Long> {
	
	// findById() 메소드와 유사하게 id 필드 대신 다른 필드를 이용해서 검색하는 기능을 구현하려면
	// JpaRepository 인터페이스에서 메소드가 상속되지 않기 때문에 검색하려는 필드 이름이 맨 뒤에
	// 사용되는 추상 메소드를 선언해 사용하면 된다.
	// abstract public 생략가능 인터페이스는 추상메소드만 가질 수 있다. 몸통 있으면 안됨
	
	// 메소드 명명 규칙: findBy필드명
	
	// 중복되는 이름이 없을 경우 사용할 메소드
//	abstract public Member findByName(String name);
	
	// 중복되는 이름이 있을 경우 사용할 메소드
	abstract public List<Member> findByName(String name);
	List<Member> findByName(String name, Sort sort);
	
	// 접두어만 다르게 사용해서 같은 기능이 실행되는 메소드들을 만들어 사용할 수 있다.
	// 여러 접두어를 사용할 수 있지만 find를 사용하자.
	List<Member> findByEmail(String email);
	List<Member> getByEmail(String email);
	List<Member> readByEmail(String email);
	List<Member> queryByEmail(String email);
	List<Member> searchByEmail(String email);
	List<Member> streamByEmail(String email);
//	List<Member> memberByEmail(String email); // 에러 발생
//	List<Member> MemberByEmail(String email); // 에러 발생
//	List<Member> findmemberByEmail(String email); // 에러 발생
	List<Member> findMemberByEmail(String email); // entity 이름을 넣을 수도 있다.
//	List<Member> writeByEmail(String email); // 에러 발생, 모든 단어가 허용되지 않는다.
	
	// First, Top이 사용되는 메소드를 만들어 사용하면 limit가 사용되는 쿼리가 실행된다.
	// Last는 없다.
	// 메소드 명명 규칙: findFirst숫자By필드명, findTop숫자By필드명
	// First, Top 뒤에 limit에 사용할 숫자를 지정한다.
	List<Member> findFirst1ByName(String name);
	List<Member> findTop2ByName(String name);
	
	// First를 사용하면 검색 결과의 앞부터 First 뒤에 지정한 숫자 크기만큼 데이터를 얻어온다.
	// 만약 지원되지는 않지만 First 대신 Last를 사용한다면 Last가 무시되고 findByName(String name)
	// 메소드와 같은 기능이 실행된다.
	List<Member> findLast1ByName(String name);
	
	// and, or 조건
	
	
	
	// after(초과), before(미만) 조건
	
	
	
	// 이상, 이하 조건
	
	
	
	// between 조건
	
	
	
	// null값 조회
	
	
	
	// in, not in
	
	
	
	// like
	
	
	
	// 정렬
	
	
	
}
