package com.tjoeun.jpa.domain;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

import com.tjoeun.jpa.repository.MemberHistoryRepository;
import com.tjoeun.jpa.support.BeanUtils;

// Member Entity에 데이터가 입력될 때 또는 수정될 때 MemberHistoryListener의 메소드가 실행되야
// 하므로 Member Entity의 @EntityListeners 어노테이션의 value 속성에 MemberHistoryListener.class
// 를 추가한다.
public class MemberHistoryListener {
	
	// Entity Listener는 @Autowired로 bean을 자동으로 주입받지 못한다.
//	@Autowired
//	private MemberHistoryReHistory memberHistoryReHistory;
	
	// @PrePersist, @PreUpdate 어노테이션을 연달아 사용하면 insert, update 전 모두 메소드가 실행된다. 
//	@PrePersist
//	@PreUpdate
	@PostPersist
	@PostUpdate
	public void prePersistAndPreUpdate(Object o) {
		System.out.println("MemberHistoryListener의 prePersistAndPreUpdate() 메소드");
		System.out.println(o.getClass().getName());
		
		// Entity Listener는 @Autowired로 bean을 자동으로 주입받지 못하기 때문에 @Autowired를
		// 사용한 경우 아래 print의 출력은 null이 출력된다.
//		System.out.println("MemberHistoryRepository: "+ memberHistoryRepository);
		
		// 11/21
		// EntityListener는 @Autowired로 bean을 자동으로 주입받지 못하기 때문에 bean을 주입받는
		// 객체(BeanUtils)를 사용해서 bean을 주입받는다.
		MemberHistoryRepository memberHistoryRepository = BeanUtils.getBean(MemberHistoryRepository.class);
		// Entity Listener는 @Autowired로 bean을 자동으로 주입받지 못하기 때문에 @Autowired를
		// 사용한 경우 아래 print의 출력은 null이 출력되고, bean을 주입받는 객체(BeanUtils)를
		// 사용해야 Repository 객체가 출력된다.
		System.out.println("MemberHistoryRepository: "+ memberHistoryRepository);
		
		// Member Entity에 데이터가 입력 또는 수정되면 MemberHistoryListener로 Member Entity가
		// 넘어오므로 MemberHistory Entity를 만들어 넘어온 Member Entity 정보를 저장한다.
		Member member = (Member) o;
		System.out.println(member);	
		MemberHistory memberHistory = new MemberHistory();
		memberHistory.setMemberId(member.getId()); // 입력 또는 수정된 member의 id를 넣어준다.
		memberHistory.setName(member.getName());
		memberHistory.setEmail(member.getEmail());
		memberHistoryRepository.save(memberHistory);
		System.out.println(memberHistory);	
	}
	
}
