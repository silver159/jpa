package com.tjoeun.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private Long memberId; // 수정된 member의 id를 기억할 필드
	private String name;
	private String email;
//	@CreatedDate
//	private LocalDateTime createAt;
//	@LastModifiedDate
//	private LocalDateTime updateAt;
	
}
