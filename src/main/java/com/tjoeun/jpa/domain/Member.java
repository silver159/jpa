package com.tjoeun.jpa.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
public class Member {
	
	// @Entity 어노테이션을 붙여서 테이블로 생성하려는 경우 반드시 기본키 필드를 설정해야 한다.
	@Id // 기본키로 사용할 필드는 @Id 어노테이션을 붙여서 선언한다.
	@GeneratedValue // 기본키 필드에 저장되는 값 자동증가
	private Long id; // 기본키 필드의 데이터 타입은 Long으로 설정한다.
	
	@NonNull
	private String name;
	@NonNull
	private String email;
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
	
	
}
