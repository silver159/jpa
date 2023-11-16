package com.tjoeun.jpa.repository;

import static org.assertj.core.api.Assertions.catchIndexOutOfBoundsException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.annotation.Transactional;

import com.tjoeun.jpa.domain.Member;

// @SpringBootTest 어노테이션을 붙여서 테스트 클래스임을 springBoot에게 알려준다.
@SpringBootTest
class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;
	
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
		
//		List<Member> members = memberRepository.findFirst1ByName("홍길동");
//		members.forEach(System.out::println);
//		members = memberRepository.findTop2ByName("홍길동");
//		members.forEach(System.out::println);
//		members = memberRepository.findLast1ByName("홍길동");
//		members.forEach(System.out::println);
		
		List<Member> members = memberRepository.findByName("홍길동", Sort.by(Direction.DESC, "id"));
		members.forEach(System.out::println);
		
	}
}
