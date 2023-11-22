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
@NoArgsConstructor // 필수
@Data // 필수
// @EntityListeners 어노테이션으로 사용할 Entity Listener를 지정한다.
// @EntityListeners(value = MyEntityListener.class)
// Auditable 인터페이스의 추상 메소드는 Override 하지 않아도 @Data 어노테이션이 처리한다.
// @EntityListeners(value = AuditingEntityListener.class)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Book extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String category;
	private Long authorId;
	private Long publisherId;
	
	// 1:1 연관 관계 설정해서 BookReviewInfo Entity를 직접 참조하게 한다.
//	@OneToOne
	// mappedBy 옵션을 아래와 같이 지정하면 Book Entity에서는 참조키(book_review_info_id)를
	// 가지지 않는다.
	@OneToOne(mappedBy = "book")
	@ToString.Exclude // toString() 메소드를 제외한다.
	private BookReviewInfo bookReviewInfo;
	
//	private String author; // 다른 테이블에서 가져옴
	
//	@CreatedDate
//	private LocalDateTime createAt;
//	@LastModifiedDate
//	private LocalDateTime updateAt;
	
	// 대부분의 Entity는 Book Entity의 prePersist(), preUpdate() 메소드와 같은 작성일과 수정일을
	// 저장하는 메소드가 필요할 것이다.
	// 매번 Entity를 생성할 때 마다 prePersist(), preUpdate() 메소드를 만들어서 사용해도 되지만
	// 같은 작업이 반복되므로 코드 리팩토링 차원에서 Entity Listener를 지정해서 사용하는 것을
	// 권장한다.
	
	// Entity Listener를 지정했으므로 prePersist(), preUpdate() 메소드는 제거한다.
//	@PrePersist
//	public void prePersist() {
//		createAt = LocalDateTime.now();
//		updateAt = LocalDateTime.now();
//	}
//	
//	@PreUpdate
//	public void preUpdate() {
//		updateAt = LocalDateTime.now();
//	}
}
