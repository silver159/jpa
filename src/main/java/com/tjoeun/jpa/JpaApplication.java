package com.tjoeun.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
// 데이터 작성 및 수정일 저장은 매우 빈번하게 사용되는 기능이기 때문에 springBoot는 기본 
// 리스너를 제공한다.
// 기본 리스너를 사용하려면 Application(main() 메소드가 있는) 클래스에 @EnableJpaAuditing
// 어노테이션을 붙여준다.
// 기본 리스너를 적용할 Entity 클래스의 @EntityListeners 어노테이션에 
// AuditingEntityListener.class를 지정하고 기본 리스너가 동작될 필드가 @PrePersist가 적용될 경우
// @CreatedDate 어노테이션을 븥여주고 @PreUpdate가 적용될 경우 @LastModifiedDate 어노테이션을
// 붙여주면 기본 리스너가 동작된다.
@EnableJpaAuditing 
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

}
