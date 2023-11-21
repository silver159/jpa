package com.tjoeun.jpa.support;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

// EntityListeners(MemberHistoryListener)는 @Autowired 어노테이션에 의해서 자동으로 bean을 
// 주입받지 못하기 때문에 bean을 주입받는 객체를 ApplicationContextAware 인터페이스를 구현받아 
// @Component 어노테이션을 붙여서 만들어 사용한다.
@Component
public class BeanUtils implements ApplicationContextAware {
	
	private static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		
		BeanUtils.applicationContext = applicationContext;
	}
	
	// bean을 만들어서 리턴시키는 메소드
	public static<T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}
}
