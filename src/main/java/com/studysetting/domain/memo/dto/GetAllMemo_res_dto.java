package com.studysetting.domain.memo.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class GetAllMemo_res_dto {

	private Long memoId;
	private String author; // 이후 authorId로 변경하
	private String title;
	private String content;
	private Date createDate;
	private Date updateDate;
	
	@Builder
	public GetAllMemo_res_dto(Long memoId, String author, String title, String content, Date createDate,
			Date updateDate) {
		this.memoId = memoId;
		this.author = author;
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	
	
}
