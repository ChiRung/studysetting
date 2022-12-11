package com.studysetting.domain.memo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Getter
@Entity(name = "memo")
public class MemoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memoId;

	private String author; // 이후 authorId로 변경하

	private String title;

	private String content;

	@CreatedDate
	private Date createDate;

	@LastModifiedDate
	private Date updateDate;

	@Builder
	public MemoEntity(Long memoId, String author, String title, String content, Date createDate, Date updateDate) {
		this.memoId = memoId;
		this.author = author;
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

}