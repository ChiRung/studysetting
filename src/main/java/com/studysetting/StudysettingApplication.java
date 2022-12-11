package com.studysetting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //entity에서 생성일, 수정일을 자동으로 입력하기 위해 추가함
@SpringBootApplication
public class StudysettingApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudysettingApplication.class, args);
	}
}
