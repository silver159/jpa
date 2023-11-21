package com.tjoeun.jpa.domain;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@EntityListeners(value = AuditingEntityListener.class)
@Data
// 부모 클래스로 부터 상속받은 필드는 @Entity 어노테이션이 테이블의 필드로 만들지 못한다.
// @MappedSuperclass 어노테이션을 부모 클래스에 붙여주면 부모 클래스를 상속받은 자식 클래스에서
// 물리적으로 필드를 선언하지 않았어도 @Entity 어노테이션 테이블의 필드로 포함시킨다.
@MappedSuperclass
public class BaseEntity implements Auditable {
	
	@CreatedDate
	private LocalDateTime createAt;
	@LastModifiedDate
	private LocalDateTime updateAt;
	
}
