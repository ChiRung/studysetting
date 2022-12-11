package com.studysetting.domain.memo.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

// @RequiredArgsConstructor
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

	private Date createDate;

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