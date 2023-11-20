package com.tjoeun.jpa.domain;

import java.time.LocalDateTime;

// MyEntityListener를 사용하는 Entity인가 식별하기 위해서 표시 인터페이스를 만든다.
public interface Auditable {
	
	// 부모에 getters & setter를 만들어 준다.
	LocalDateTime getCreateAt();
	LocalDateTime getUpdateAt();
	void setCreateAt(LocalDateTime createAt);
	void setUpdateAt(LocalDateTime uadateAt);
	
}
