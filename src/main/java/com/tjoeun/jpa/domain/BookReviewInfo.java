package com.tjoeun.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BookReviewInfo extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // PK
	
	// 1:1 연관 관계 설정을 위해 아래 코드를 주석으로 처리하고 book Entity를 직접 참조하게 한다.
//	private Long bookId; // FK
//	@OneToOne 어노테이션을 참조하게 할 Entity에 지정해서 1:1 연관 관계를 설정한다.
//	@OneToOne // 있을 수도 있고 없을 수도 있는 값 - 내부적으로 left outer join이 걸린다.
	@OneToOne(optional = false) // 반드시 존재하는 값 - 내부적으로 inner join이 걸린다.
	private Book book;
	
	// null check를 할 필요가 없으면 int, float 같은 기본 자료형을 사용하고 null check를 
	// 하려면 Integer, Float와 같은 래퍼 클래스 형태로 사용한다.
	private int reviewCount;
	private float averageReviewScore;
	// createAt, updateAt은 BaseEntity에서 상속받아 사용한다.
}
