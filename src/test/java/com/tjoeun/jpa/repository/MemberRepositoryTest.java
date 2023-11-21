package com.tjoeun.jpa.repository;

import static org.assertj.core.api.Assertions.catchIndexOutOfBoundsException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.tjoeun.jpa.domain.Gender;
import com.tjoeun.jpa.domain.Member;

// @SpringBootTest 어노테이션을 붙여서 테스트 클래스임을 springBoot에게 알려준다.
@SpringBootTest
class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private MemberHistoryRepository memberHistoryRepository;
	
	@Test
	@Transactional 
	public void crud() {
		
//		Member member = new Member("홍길동", "a@a.com");
//		memberRepository.save(member);
		
//		System.err.println(memberRepository.findAll());
		// 여러 줄로 출력한다.
//		for (Member m : memberRepository.findAll()) {
//			System.out.println(m);
//		}
		// 람다식을 사용해서 여러 줄로 출력한다.
//		memberRepository.findAll().forEach(System.out::println);
		
		// 11/16
		
		// 전체 데이터 가져오기 => findAll()
//		List<Member> members = memberRepository.findAll();
//		System.out.println(members);
		// 여러 줄로 출력한다.
//		for (Member m : members) {
//			System.out.println(m);
//		}
		// 람다식을 사용해서 여러 줄로 출력한다.
//		members.forEach(System.out::println);
		
		// 전체 데이터를 정렬해서 가져오기 => findAll(Sort.by(정렬기준, 필드이름))
//		List<Member> members = memberRepository.findAll(Sort.by(Direction.DESC, "id"));
//		members.forEach(System.out::println);
		
		// 특정 데이터 가져오기 => findById(id) => 단일 데이터
		// @Transactional 어노테이션을 붙여주면 세션이 유지되므로 정상적으로 처리되지만 
		// 붙여주지 않으면 세션이 유지되지 않기 때문에 에러가 발생된다.
		// import org.springframework.transaction.annotation.Transactional;
//		Member member = memberRepository.getOne(1L); // getOne은 null 처리 안됨
//		Optional<Member> member = memberRepository.findById(1L);
//		Member member = memberRepository.findById(10L).orElse(null); // null 처리 가능, 제일 많이 사용하는 방법
//		Member member = memberRepository.findById(10L).orElseThrow(RuntimeException::new); // try ~ catch 사용
//		System.out.println(member);
		
		
		// 특정 데이터 가져오기 => findAllById(id List) => 전체 데이터 중 지정된 데이터
//		List<Long> ids = new ArrayList<Long>();
//		ids.add(1L);
//		ids.add(3L);
//		ids.add(4L);
//		List<Member> members = memberRepository.findAllById(ids);
//		List<Member> members = memberRepository.findAllById(Lists.newArrayList(1L,3L,4L)); // import org.assertj.core.util.Lists;
//		members.forEach(System.out::println);
		
		// 일괄 데이터 저장하기 => saveAll(entity List)
//		Member member1 = new Member("손오공", "son@tjoeun.com");
//		Member member2 = new Member("저팔계", "jeo@tjoeun.com");
//		memberRepository.saveAll(Lists.newArrayList(member1,member2));
//		memberRepository.findAll().forEach(System.out::println);
		
		// 단일 데이터 저장하기 => save(entity)
//		Member member = new Member("사오정", "sa@tjoeun.com");
//		memberRepository.save(member);
//		================================================================
//		memberRepository.save(new Member("삼장법사", "sam@tjoeun.com"));
//		memberRepository.flush(); // 즉시 실행
//		================================================================
//		memberRepository.saveAndFlush(new Member("마인부우", "ma@tjoeun.com"));
//		memberRepository.findAll().forEach(System.out::println);
		
		// 저장된 데이터 개수 얻어오기 => count()
//		long count = memberRepository.count();
//		System.out.println(count);
		
		// 지정된 아이디에 해당되는 데이터 존재여부 얻어오기 => existsById(id)
//		boolean exist = memberRepository.existsById(1L);
//		System.out.println(exist);
		
		// 전체 데이터 삭제하기 => deleteAll()
//		memberRepository.deleteAll(); // 이거 사용
//		memberRepository.deleteAllInBatch(); // 많이 있을 때 사용
//		memberRepository.findAll().forEach(System.out::println);
		
		// 전체 데이터 중에서 특정 데이터 삭제하기 => deleteAll(entity List)
//		memberRepository.deleteAllById(Lists.newArrayList(2L,5L,6L));
//		memberRepository.deleteAll(
//			memberRepository.findAllById(Lists.newArrayList(2L,5L,6L)));  // 이걸 많이 사용
//		memberRepository.findAll().forEach(System.out::println);
		
		// 단일 데이터 삭제하기 => delete(entity), deleteById(id)
//		memberRepository.deleteById(2L);
//		memberRepository.delete(memberRepository.findById(2L).orElse(null)); // 없으면 에러 발생
//		memberRepository.findAll().forEach(System.out::println);
		
		// 단일 데이터 수정하기 => save(entity)
		// 수정할 데이터를 얻어온다.
//		Member member = memberRepository.findById(1L).orElse(null);
//		System.out.println("수정전: " + member);
		// 얻어온 데이터를 수정한다.
//		member.setName("배지터");
//		member.setEmail("bae@tjoeun.com");
//		member.setUpdateAt(LocalDateTime.now());
//		System.out.println("수정후: " + member);
		// 수정할 데이터를 저장한다.
//		memberRepository.save(member);
//		memberRepository.findAll().forEach(System.out::println);
		
		// 페이징 - Page 인터페이스 => findAll(페이지 요청)
		// import org.springframework.data.domain.Page;
		// 페이지 요청: PageRequest.of(얻어올 페이지 번호(인덱스), 페이지의 크기)
//		Page<Member> page = memberRepository.findAll(PageRequest.of(1, 4));
//		Page<Member> page = memberRepository.findAll(PageRequest.of(1, 4, Sort.by(Direction.DESC, "id")));
//		System.out.println(page);
//		page.forEach(System.out::println); // 현재 가능
//		page.getContent().forEach(System.out::println); // 현재 페이지의 데이터 출력. 예전방법
//		System.out.println(page.getTotalElements()); // 전체 데이터 개수, totalCount
//		System.out.println(page.getSize()); // 페이지의 크기, pageSize
//		System.out.println(page.getTotalPages()); // 전체 페이지 개수, totalPage
//		System.out.println(page.getNumberOfElements()); // 현재 페이지의 데이터 개수
//		System.out.println(page.getSort()); // 정렬 여부, id: DESC
	}
	
// 파생쿼리	
// JUnit으로 특정 테스트 메소드만 실행하려면 메소드 이름에 커서를 위치시키고 ctrl + F11을
// 눌러 실행한다.
	@Test
	@Transactional
	public void select() { // private으로 만들면 실행 안됨.
		
		// id 필드 대신 다른 필드를 이용해서 검색
		// Member findByName(String name) 형태로 작성된 메소드를 실행하면 리턴 타입이 단일 객체
		// 형태이므로 name 필드에 중복되는 데이터가 있으면 에러가 발생되고 중복되는 데이터가
		// 없으면 정상 실행된다.
//		Member member = memberRepository.findByName("홍길동"); // 에러
//		System.out.println(member);
		
		// List<Member> findByName(String name) 형태로 작성된 메소드를 실행해야 리턴 타입이  
		// List 형태이므로 name 필드에 중복되는 데이터가 있더라도 에러 없이 처리가 가능하다.
//		List<Member> members = memberRepository.findByName("임꺽정"); // 정상 실행
//		members.forEach(System.out::println);
//		members = memberRepository.findByName("홍길동");
//		members.forEach(System.out::println);
		
		// 접두어만 다르게 사용
//		System.out.println("findByEmail >> " + memberRepository.findByEmail("hong@tjoeun.com"));
//		System.out.println("getByEmail >> " + memberRepository.getByEmail("hong@tjoeun.com"));
//		System.out.println("readByEmail >> " + memberRepository.readByEmail("hong@tjoeun.com"));
//		System.out.println("queryByEmail >> " + memberRepository.queryByEmail("hong@tjoeun.com"));
//		System.out.println("searchByEmail >> " + memberRepository.searchByEmail("hong@tjoeun.com"));
//		System.out.println("streamByEmail >> " + memberRepository.streamByEmail("hong@tjoeun.com"));
//		System.out.println("memberByEmail >> " + memberRepository.memberByEmail("hong@tjoeun.com")); // 에러
//		System.out.println("MemberByEmail >> " + memberRepository.MemberByEmail("hong@tjoeun.com")); // 에러
//		System.out.println("findmemberByEmail >> " + memberRepository.findmemberByEmail("hong@tjoeun.com")); // 에러
//		System.out.println("findMemberByEmail >> " + memberRepository.findMemberByEmail("hong@tjoeun.com"));
//		System.out.println("writeByEmail >> " + memberRepository.writeByEmail("hong@tjoeun.com")); // 에러
		
		// First, Top
//		List<Member> members = memberRepository.findFirst1ByName("홍길동");
//		members.forEach(System.out::println);
//		members = memberRepository.findTop2ByName("홍길동");
//		members.forEach(System.out::println);
//		members = memberRepository.findLast1ByName("홍길동");
//		members.forEach(System.out::println);
		
//		List<Member> members = memberRepository.findByName("홍길동", Sort.by(Direction.DESC, "id"));
//		members.forEach(System.out::println);
		
		// 11/17
		// and, or 조건
//		List<Member> members = memberRepository.findByNameAndEmail("홍길동", "gildong@tjoeun.com");
//		List<Member> members = memberRepository.findByEmailAndName("gildong@tjoeun.com", "홍길동");
//		List<Member> members = memberRepository.findByNameOrEmail("임꺽정", "jang@tjoeun.com");
//		List<Member> members = memberRepository.findByEmailOrName("jang@tjoeun.com", "임꺽정");
//		members.forEach(System.out::println);
		
		// after(초과), before(미만) 조건
//		List<Member> members = memberRepository.findByCreateAtAfter(LocalDateTime.now().minusDays(1L));
//		List<Member> members = memberRepository.findByCreateAtBefore(LocalDateTime.now().plusDays(1L));
//		List<Member> members = memberRepository.findByIdGreaterThan(3L);
//		List<Member> members = memberRepository.findByIdLessThan(3L);
//		members.forEach(System.out::println);
		
		// 이상, 이하 조건
//		List<Member> members = memberRepository.findByIdGreaterThanEqual(3L);
//		List<Member> members = memberRepository.findByIdLessThanEqual(3L);
//		members.forEach(System.out::println);
		
		// 복합 조건
//		List<Member> members = memberRepository.findByIdGreaterThanEqualAndIdLessThanEqual(2L, 5L);
//		List<Member> members = memberRepository.findByIdGreaterThanEqualAndIdLessThan(2L, 5L);
//		List<Member> members = memberRepository.findByIdGreaterThanAndIdLessThanEqual(2L, 5L);
//		List<Member> members = memberRepository.findByIdGreaterThanAndIdLessThan(2L, 5L);
//		members.forEach(System.out::println);
		
		// between 조건 => ~ 이상이고(And) ~ 이하인
//		List<Member> members = memberRepository.findByIdBetween(2L, 5L);
//		members.forEach(System.out::println);
		
		// null값 조회
//		Member member = new Member();
//		memberRepository.save(member);
//		List<Member> members = memberRepository.findByNameIsNull();
//		List<Member> members = memberRepository.findByEmailIsNotNull();
//		members.forEach(System.out::println);
		
		// in, not in
		// Lists.newArrayList() 실전에서 사용 잘 안함
//		List<Member> members = memberRepository.findByNameIn(Lists.newArrayList("홍길동", "임꺽정"));
//		List<Member> members = memberRepository.findByemailNotIn(
//				Lists.newArrayList("hong@tjoeun.com", "gildong@tjoeun.com", "honghong@tjoeun.com")
//			);
//		members.forEach(System.out::println);
		
		// like => 부분일치 => ~로 시작하는, ~로 끝나는, ~를 포함하는
//		List<Member> members = memberRepository.findByNameLike("홍%"); // "홍"으로 시작하는
//		List<Member> members = memberRepository.findByNameStartingWith("홍"); // "홍"으로 시작하는
//		List<Member> members = memberRepository.findByNameLike("%산"); // "산"으로 끝나는
//		List<Member> members = memberRepository.findByNameEndingWith("산"); // "산"으로 끝나는
//		List<Member> members = memberRepository.findByNameLike("%길%"); // "길"을 포함하는
//		List<Member> members = memberRepository.findByNameContains("길"); // "길"을 포함하는
//		members.forEach(System.out::println);
		
		// 정렬
//		List<Member> members = memberRepository.findByNameOrderByEmailAsc("홍길동"); 
//		List<Member> members = memberRepository.findByNameOrderByIdDesc("홍길동"); 
//		List<Member> members = memberRepository.findTopByNameOrderByIdAsc("홍길동"); 
//		List<Member> members = memberRepository.findTopByNameOrderByIdDesc("홍길동"); 
//		List<Member> members = memberRepository.findFirstByNameOrderByIdAsc("홍길동"); 
//		List<Member> members = memberRepository.findFirstByNameOrderByIdDesc("홍길동"); 
//		List<Member> members = memberRepository.findAllByOrderByIdDesc(); 
//		List<Member> members = memberRepository.findTop3AllByOrderByIdDesc(); 
//		List<Member> members = memberRepository.findByNameOrderByEmailDesc("홍길동"); 
//		List<Member> members = memberRepository.findByNameOrderByEmailDescIdDesc("홍길동");
		 
		// Sort.by(Direction.DESC, "id") => Direction은 Enum. 정렬 기준이 1개일 때 사용한다.
		// Sort.by(Order.desc("email"), Order.desc("id")) => Order는 정렬 기준이 2개 이상일 때
		// 사용한다.
		// import org.springframework.data.domain.Sort.Order;
//		List<Member> members = memberRepository.
//				findTop3ByName("홍길동", Sort.by(Order.desc("email"), Order.desc("id"))); 
//		List<Member> members = memberRepository.findAll(getSort()); 
//		members.forEach(System.out::println);
		
	}
	// 정렬 기준이 지정된 Sort 객체를 리턴하는 메소드
	private Sort getSort() {
		return Sort.by(
			Order.asc("name"), 
			Order.desc("email"), 
			Order.desc("id")
		);
	}
	
	@Test
	@Transactional
	public void pagingTest() {
		
//		Page<Member> pages = memberRepository.
//			findByName("홍길동", PageRequest.of(0, 1, Sort.by(Direction.DESC, "id")));
//			findByName("홍길동", PageRequest.of(0, 1, Sort.by(Order.desc("id"))));
		Page<Member> pages = memberRepository.
//			findAll(PageRequest.of(0, 4, Sort.by(Direction.DESC, "id")));
			findAll(PageRequest.of(0, 4, Sort.by(Order.desc("id"))));
//		pages.forEach(System.out::println);
//		pages.getContent().forEach(System.out::println);
		
//		System.out.println(pages.getTotalElements()); // 전체 데이터 개수
//		System.out.println(pages.getTotalPages()); // 전체 페이지 개수
//		System.out.println(pages.getSize()); // 페이지의 크기
//		System.out.println(pages.getNumber()); // 현재 페이지의 인덱스, 페이지 번호
//		System.out.println(pages.getNumberOfElements()); // 현재 페이지의 데이터 개수
//		System.out.println(pages.getSort()); // 정렬 여부, id: DESC
//		
//		System.out.println(pages.hasContent()); // 페이지 객체가 데이터를 가지고 있으면 true, 없으면 false
//		System.out.println(pages.hasNext()); // 다음 페이지가 있으면 true, 없으면 false
//		System.out.println(pages.hasPrevious()); // 이전 페이지가 있으면 true, 없으면 false
//		System.out.println(pages.isFirst()); // 현재 페이지가 첫번째 페이지면 true, 아니면 false
//		System.out.println(pages.isLast()); // 현재 페이지가 마지막 페이지면 true, 아니면 false
		
//		System.out.println(pages.nextPageable()); // 다음 페이지가 있으면 다음 페이지 객체를 리턴한다.
		// 0 Page request [number: 1, size 4, sort: id: DESC], 1 INSTANCE
//		System.out.println(pages.previousPageable()); // 이전 페이지가 있으면 이전 페이지 객체를 리턴한다.
		// 다음 페이지 또는 이전 페이지가 없으면 INSTANCE가 리턴된다.
		
		// default 메소드
		// nextOrLastPageable() 메소드는 현재 페이지가 마지막 페이지라면 nextPageable() 메소드는
		// INSTANCE가 리턴되지만 nextOrLastPageable() 메소드는 마지막 페이지 객체가 리턴된다.
//		System.out.println(pages.nextOrLastPageable());
		// previousOrFirstPageable() 메소드는 현재 페이지가 첫 페이지라면 previousPageable() 
		// 메소드는 INSTANCE가 리턴되지만 previousOrFirstPageable() 메소드는 첫 페이지 객체가 
		// 리턴된다.
//		System.out.println(pages.previousOrFirstPageable());
		
	}
	
	// 11/20
	@Test
	@Transactional
	public void insertAndUpdateTest() {
		
		Member member = new Member("홍길동", "hoooong@tjoeun.com");
		memberRepository.save(member); // insert
		
		member = memberRepository.findById(1L).orElseThrow(RuntimeException::new);
		member.setName("임꺽ㄱㄱㄱㄱㄱㄱㄱㄱㄱ정");
		memberRepository.save(member); // update
		
		List<Member> members = memberRepository.findAll(getSort()); 
		members.forEach(System.out::println);
	}
	
	@Test
	@Transactional
	public void enumTest() {
		Member member = memberRepository.findById(1L).orElseThrow(RuntimeException::new);
		member.setGender(Gender.MALE);
		memberRepository.save(member); // update
		
		List<Member> members = memberRepository.findAll(); 
		members.forEach(System.out::println);
		
		System.out.println(memberRepository.findRawRecord().get("gender"));
	}
	
	@Test
	@Transactional
	public void listernertest() {
		
		Member member = new Member("홍길동", "hoooong@tjoeun.com");
		memberRepository.save(member); // insert
		
		member = memberRepository.findById(1L).orElseThrow(RuntimeException::new);
		member.setName("임꺽ㄱㄱㄱㄱㄱㄱㄱㄱㄱ정");
		memberRepository.save(member); // update
		
		memberRepository.deleteById(2L); // delete
		
		List<Member> members = memberRepository.findAll(); 
		members.forEach(System.out::println);
	}
	
	@Test
	@Transactional
	public void prePersistTest() {
		
		Member member = new Member();
		member.setName("홍길동");
		member.setEmail("honghong@tjoeun.com");
		// 최초 저장 시간이나 수정 시간을 Entity가 저장되거나 수정되는 시점에서 코딩을 하면
		// 사소한 실수를 유발할 수 있다.
		// 이 문제를 해결하기 위해 @PrePersist나 @PreUpdate 메소드에서 처리하는 것을 권장한다.
		// Member.java로 옴긴다.
//		member.setCreateAt(LocalDateTime.now()); // 최초로 저장되는 시간
//		member.setUpdateAt(LocalDateTime.now()); // 수정되는 시간
		memberRepository.save(member); // insert
		
		List<Member> members = memberRepository.findAll(); 
		members.forEach(System.out::println);
	}
	
	@Test
	@Transactional
	public void preUpdateTest() {
		
		Member member = memberRepository.findById(1L).orElseThrow(RuntimeException::new);
		System.out.println("수정전: " + member);
		member.setName("임꺽ㄱㄱㄱㄱㄱㄱㄱㄱㄱ정");
//		member.setUpdateAt(LocalDateTime.now()); // 수정되는 시간
		memberRepository.save(member); // update
		System.out.println("수정후: " + memberRepository.findAll().get(0));
		System.out.println("수정후: " + memberRepository.findById(1L).orElseThrow(RuntimeException::new));
	}
	
	@Test
	@Transactional
	public void memberHistoryTest() {
		
		Member member = new Member();
		member.setName("손오공");
		member.setEmail("son@tjoeun.com");
		memberRepository.save(member); // insert
		
		member.setName("저팔계");
		member.setEmail("jeo@tjoeun.com");
		memberRepository.save(member); // update
		memberRepository.findAll().forEach(System.out::println);
		memberHistoryRepository.findAll().forEach(System.out::println);
	}
}
