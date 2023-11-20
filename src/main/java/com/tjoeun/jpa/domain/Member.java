package com.tjoeun.jpa.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor // 기본 생성자 자동완성, 필수
@AllArgsConstructor // 모든 멤버를 초기화하는 생성자 자동완성
@RequiredArgsConstructor // @NonNull 어노테이션을 붙여 선언한 필드만 초기화하는 생성자 자동완성
// @Getter, @Setter 어노테이션을 클래스에 붙이면 모든 필드의 getters & setters 메소드를 
// 자동으로 생성하고 필드에 붙이면 @Getter, @Setter 어노테이션을 붙여준 필드의 @Getter & @Setter
// 메소드만 자동으로  생성한다.
// @Getter // getters 메소드 자동완성
// @Setter // setters 메소드 자동완성
// @ToString // toString() 메소드 자동 override
// @EqualsAndHashCode // equals, hashCode 메소드 자동 override
@Data // @Getter, @Setter, @ToString, @EqualsAndHashCode를 모두 실행한다.
@Builder
// @Entity 어노테이션을 붙여준 클래스는 springBoot가 실행될 때 클래스 이름을 테이블 이름으로 하고
// 필드 이름을 테이블의 필드 이름으로 하는 테이블이 자동으로 만들어진다.
@Entity
// @Entity 어노테이션을 붙여준 클래스는 JPA 클래스 이름을 테이블 이름으로 하는 테이블을 자동으로
// 만들어주는데 테이블 이름을 클래스 이름이 아닌 다른 이름으로 사용하려는 경우 @Table 
// 어노테이션의 name 속성으로 클래스 이름과 다른 테이블 이름으로 지정할 수 있다. 
// import javax.persistence.Table;
// indexes 속성으로 인덱스로 만들 필드를 지정할 수 있다.
// uniqueConstraints 속성으로 유니크 제약조건(중복되는 값은 입력할 수 없다.)을 설정할 필드를 
// 지정할 수 있다.
// @Table(name="Member", indexes = {@Index(columnList = "name")}, 
//	uniqueConstraints = {@UniqueConstraint(columnNames = "email")}) 
// create index IDXcqf69e6y97y1ypi8mhby51mw6 on user1 (name)
// alter table user1 
// add constraint UK5go5bwi54dl7876oxqhu7k1es unique (email)
// Member Entity에서 데이터 입력 또는 수정이 발생되면 MemberHistory Entity에 저장을 해야하므로
// MemberHistoryListener를 추가한다.
// 2개 이상의 Listener를 사용하려면 {}에 묶어서 ","로 구분해서 나열하면 된다.
@EntityListeners(value = {MyEntityListener.class, MemberHistoryListener.class})
public class Member implements Auditable{
	
	// @Entity 어노테이션을 붙여서 테이블로 생성하려는 경우 반드시 기본키 필드를 설정해야 한다.
	@Id // 기본키로 사용할 필드는 @Id 어노테이션을 붙여서 선언한다.
	// @GeneratedValue 어노테이션의 strategy 속성
	// GenerationType.AUTO: 자동, 기본값
	// GenerationType.SEQUENCE: h2, oracle, postgresql과 같이 sequence를 사용하는 데이터베이스의
	// 기본값 자동증가
	// GenerationType.IDENTITY: mysql, mariadb와 같이 auto_increment를 사용하는 데이터베이스의 
	// 기본값 자동증가
	// GenerationType.TABLE: 데이터베이스 종류와 관계없이 id를 관리하는 테이블을 만들어 두고
	// 추출해서 사용한다.
	// 모든 테이블이 같이 id가 증가하게 하려면 GenerationType.SEQUENCE로 지정한다.
	// 모든 테이블이 독립적으로 id가 증가하게 하려면 GenerationType.IDENTITY로 지정한다.
//	@GeneratedValue // 기본키 필드에 저장되는 값 자동증가, AUTO
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id; // 기본키 필드의 데이터 타입은 Long으로 설정한다.
	
	@NonNull
	private String name;
	@NonNull
	private String email;
	
	// 11/20
	// @Column 어노테이션은 테이블의 필드로 구성할 필드(멤버)에 붙인다. 지금은 붙이지 않아도 된다.
	// name 속성으로 필드(멤버) 이름과 다른 이름으로 테이블의 필드 이름을 지정할 수 있다. 
	// nullable 속성값을 false로 지정하면 null 값을 허용하지 않는 필드를 만들 수 있다.
	// unique 속성값을 true로 지정하면 중복되는 값을 허용하지 않는 필드를 만들 수 있다.
	// length 속성으로 필드의 크기를 지정할 수 있다.
//	@Column(name = "nick", nullable = false, unique = true, length = 100) // 없어도 가능
//	private String nickname;
	
	// @Transient 어노테이션은 데이터베이스에는 반영하지 않고 사용하려는 필드에 붙인다.
	// import javax.persistence.Transient;
//	@Transient 
//	private int repleCount;
	
	// update sql 명령 실행시 제외시킨다.
	@Column(updatable = false)
	private LocalDateTime createAt;
	
	// insert sql 명령 실행시 제외시킨다.
	@Column(insertable = false)
	private LocalDateTime updateAt;
	
	// enum을 사용할 때 기본값이 ORDINAL로 지정되어 있기 때문에 enum 파일에서 정의한 순서대로
	// 인덱스가 부여되므로 코딩과정에서 enum 파일의 순서가 변경되면 인덱스도 같이 변경되는
	// 문제가 발생될 수 있다.
	// 이를 방지하기 위해 @Enumerated 어노테이션의 value 속성을 EnumType.STRING으로 지정하면
	// 순서가 변경되더라도 인덱스가 아닌 문자열로 처리되므로 오류가 발생될 가능성이 낮아진다.
	@Enumerated(value = EnumType.STRING)
	private Gender gender;
	
	// JPA에서 제공하는 Entity Listener는 7가지가 있다. pre, post
//	@PrePersist // Entity가 영속화(Persist, insert)되기 전에 실행된다.
//	public void prePersist(){
//		System.out.println("insert sql 명령이 실행되기 전에 prePersist() 메소드가 실행된다.");
//		// Member 클래스이기 때문에 바로 넣어주면 된다.
//		createAt = LocalDateTime.now(); // 인수 있을 시 this 사용 this.createAt
//		updateAt = LocalDateTime.now();
//		setCreateAt(LocalDateTime.now());
//		setUpdateAt(LocalDateTime.now());
//	}
//	@PostPersist // Entity가 영속화(Persist, insert)된 후에 실행된다.
//	public void postPersist(){
//		System.out.println("insert sql 명령이 실행된 후에 postPersist() 메소드가 실행된다.");
//	}
	
//	@PreUpdate // Entity가 update되기 전에 실행된다.
//	public void preUpdate(){
//		System.out.println("update sql 명령이 실행되기 전에 preUpdate() 메소드가 실행된다.");
//		updateAt = LocalDateTime.now();
//	}
//	@PostUpdate // Entity가 update된 후에 실행된다.
//	public void postUpdate(){
//		System.out.println("update sql 명령이 실행된 후에 postUpdate() 메소드가 실행된다.");
//	}
	
//	@PreRemove // Entity가 delete되기 전에 실행된다.
//	public void preRemove(){
//		System.out.println("delete sql 명령이 실행되기 전에 preRemove() 메소드가 실행된다.");
//	}
//	@PostRemove // Entity가 delete된 후에 실행된다.
//	public void postRemove(){
//		System.out.println("delete sql 명령이 실행된 후에 postRemove() 메소드가 실행된다.");
//	}
	
//	@PostLoad // Entity가 select된 후에 실행된다.
//	public void postLoad(){
//		System.out.println("select sql 명령이 실행된 후에 postLoad() 메소드가 실행된다.");
//	}
}
