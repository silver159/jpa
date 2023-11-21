package com.tjoeun.jpa.domain;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class MyEntityListener {
	
	// Entity Listener가 여러 entity에서 사용되므로 @PrePersist, @PreUpdate 메소드로 넘어오는
	// 객체가 달라질 수 있기 때문에 모든 객체를 받아서 처리할 수 있도록 Object 타입으로 인수를
	// 지정한다.
	
	@PrePersist
	public void prePersist(Object o) {
		System.out.println("MyEntityListener의 prePersist() 메소드");
		System.out.println(o.getClass().getName());
		// 메소드의 인수로 넘어온 객체가 Auditable 인터페이스로 정상적으로 형변환이 된다면
		// MyEntityListener를 사용하는 클래스이므로 작성일과 수정일을 저장한다.
		if(o instanceof Auditable) { // 상속 받은 모든 클래스나 인터페이스는 upcast 가능
			((Auditable) o).setCreateAt(LocalDateTime.now());
			((Auditable) o).setUpdateAt(LocalDateTime.now());
		}
	}
	
	@PreUpdate
	public void preUpdate(Object o) {
		System.out.println("MyEntityListener의 preUpdate() 메소드");
		if(o instanceof Auditable) { // 상속 받은 모든 클래스나 인터페이스는 upcast 가능
			((Auditable) o).setUpdateAt(LocalDateTime.now());
		}
	}
}
