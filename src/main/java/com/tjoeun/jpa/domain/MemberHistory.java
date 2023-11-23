package com.tjoeun.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Data
// @EntityListeners(value = MyEntityListener.class)
// @EntityListeners(value = AuditingEntityListener.class)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class MemberHistory extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// Member Entity와 실제 조인될 필드 이름이 member_id인지 memberId인지 설정한다. 
	// @JoinColumn 어노테이션의 name 속성값과 같은 값으로 @@Column 어노테이션의 name 속성값을
	// 설정한다.
//	@Column(name = "member_id")
	@Column(name = "member_id", insertable = false, updatable = false)
	private Long memberId; // 수정된 member의 id를 기억할 필드
	private String name;
	private String email;
//	@CreatedDate
//	private LocalDateTime createAt;
//	@LastModifiedDate
//	private LocalDateTime updateAt;
	
	
	// MemberHistory Entity와 Member Entity의 N:1 연관 관계를 설정한다.
	// @ManyToOne 추가했을 때
	// MemberHistory column: member_id (should be mapped with insert="false" update="false")와
	// 같은 메시지가 출력되며 에러가 발생되면 @Column에 insertable, updatable 속성값을 false로
	// 지정해서 저장하지도 못하고 수정하지도 못하게 설정한다.
	@ManyToOne
	// toString() 메소드가 계속 자기가 자기를 호출하는 문제가 발생되면 stack overflow 에러가 
	// 발생된다.
	// toString() 메소드를 제외시킨다.
	@ToString.Exclude
	private Member member;
}
