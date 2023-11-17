package com.tjoeun.jpa.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
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
import lombok.ToString;

@NoArgsConstructor // 기본 생성자 자동완성
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
//@Table(name="Member", indexes = {@Index(columnList = "name")}, 
//	uniqueConstraints = {@UniqueConstraint(columnNames = "email")}) 
// create index IDXcqf69e6y97y1ypi8mhby51mw6 on user1 (name)
// alter table user1 
// add constraint UK5go5bwi54dl7876oxqhu7k1es unique (email)
public class Member {
	
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
	@Column // 없어도 가능
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
	
}
