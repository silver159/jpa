package com.tjoeun.jpa.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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
//	List<Member> findByEmail(String email);
	Member findByEmail(String email);
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
	// 한개만 가져올때는 1 쓸 필요 없다.
	List<Member> findFirst1ByName(String name);
	List<Member> findTop2ByName(String name);
	
	// First를 사용하면 검색 결과의 앞부터 First 뒤에 지정한 숫자 크기만큼 데이터를 얻어온다.
	// 만약 지원되지는 않지만 First 대신 Last를 사용한다면 Last가 무시되고 findByName(String name)
	// 메소드와 같은 기능이 실행된다.
	List<Member> findLast1ByName(String name);
	
	// 11/17
	// and, or 조건
	// 메소드 명명 규칙: findBy필드명And필드명, findBy필드명Or필드명
	List<Member> findByNameAndEmail(String name, String email);
	List<Member> findByEmailAndName(String email, String name);
	List<Member> findByNameOrEmail(String name, String email);
	List<Member> findByEmailOrName(String email, String name);
	
	// after(초과), before(미만) 조건
	// 메소드 명명 규칙: findBy필드명After, findBy필드명Before
	List<Member> findByCreateAtAfter(LocalDateTime date); // 날짜 초과
	List<Member> findByCreateAtBefore(LocalDateTime date); // 날짜 미만
	// 메소드 명명 규칙: findBy필드명GreaterThan, findBy필드명LessThan
	List<Member> findByIdGreaterThan(Long id); // id 초과
	List<Member> findByIdLessThan(Long id); // id 미만
	
	// 이상, 이하 조건
	// 메소드 명명 규칙: findBy필드명GreaterThanEqual, findBy필드명LessThanEqual
	List<Member> findByIdGreaterThanEqual(Long id); // id 이상
	List<Member> findByIdLessThanEqual(Long id); // id 이하
	
	// 복합 조건
	List<Member> findByIdGreaterThanEqualAndIdLessThanEqual(Long start, Long end); // start 이상 이고 end 이하
	List<Member> findByIdGreaterThanEqualAndIdLessThan(Long start, Long end); // start 이상 이고 end 미만
	List<Member> findByIdGreaterThanAndIdLessThanEqual(Long start, Long end); // start 초과 이고 end 이하
	List<Member> findByIdGreaterThanAndIdLessThan(Long start, Long end); // start 초과 이고 end 미만
	
	// between 조건 => ~ 이상이고(And) ~ 이하인
	// 메소드 명명 규칙: findBy필드명Between
	List<Member> findByIdBetween(Long start, Long end); // between
	
	// null값 조회
	// 메소드 명명 규칙: findBy필드명IsNull, findBy필드명IsNotNull
	List<Member> findByNameIsNull(); // name 필드에 저장된 값이 null인가?
	List<Member> findByEmailIsNotNull(); // email 필드에 저장된 값이 null이 아닌가?
	// findBy필드명IsEmpty, findBy필드명IsNotEmpty는 collection(arraylist, hashmap 등)이
	// 비어있나 비어있지 않나 비교한다.
	
	
	// in, not in
	// 메소드 명명 규칙: findBy필드명In, findBy필드명NotIn
	List<Member> findByNameIn(List<String> name);
	List<Member> findByemailNotIn(List<String> email);
	
	// like => 부분일치 => ~로 시작하는, ~로 끝나는, ~를 포함하는
	// 메소드 명명 규칙: findBy필드명Like
	List<Member> findByNameLike(String name);
	// like를 사용하면 "%"와 연결하는 과정에서 가독성을 해칠 수 있다.
	// %를 사용하지 않는다.
	List<Member> findByNameStartingWith(String name); // ~로 시작하는
	List<Member> findByNameEndingWith(String name); // ~로 끝나는
	List<Member> findByNameContains(String name); // ~를 포함하는
	
	// 정렬
	// 메소드 명명 규칙: findBy필드명OrderBy정렬할필드명Asc/Desc
	List<Member> findByNameOrderByEmailAsc(String name);
	List<Member> findByNameOrderByIdDesc(String name);
	
	// Top, First를 이용해서 1개만 얻어오려면 Top, First 뒤에 숫자는 생략 가능하다. 
	List<Member> findTopByNameOrderByIdAsc(String name); // id가 제일 작은 데이터 1개
	List<Member> findFirstByNameOrderByIdAsc(String name); // id가 제일 작은 데이터 1개
	List<Member> findTopByNameOrderByIdDesc(String name); // id가 제일 큰 데이터 1개
	List<Member> findFirstByNameOrderByIdDesc(String name); // id가 제일 큰 데이터 1개
	
	// 특정 조건을 지정하고 않고 전체 데이터를 정렬해서 얻어오려면 findAll을 사용하면 된다.
//	List<Member> findAllOrderByIdDesc(); // 에러, findAll(Sort.by(정렬기준, 필드이름))  
	List<Member> findAllByOrderByIdDesc();
	List<Member> findTop3AllByOrderByIdDesc();
	
	// data.sql 변경
	// 이름이 같으면 이메일의 내림차순으로 정렬
	List<Member> findByNameOrderByEmailDesc(String name);
	// 이름이 같으면 이메일의 내림차순으로 정렬, 이메일도 같으면 id의 내림차순 정렬
	List<Member> findByNameOrderByEmailDescIdDesc(String name);
	
	// Sort 객체를 사용해도 같은 효과를 낼 수 있다.
	List<Member> findTop3ByName(String name, Sort sort);
	
	// 페이징
	// import org.springframework.data.domain.Pageable;
	Page<Member> findByName(String name, Pageable pageable);
	
	// 11/20
	// 네이티브 쿼리
	@Query(value = "select * from member limit 1;", nativeQuery = true)
	Map<String, Object> findRawRecord();
}
