package com.studysetting.domain.memo.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class GetAllMemo_res_dto {

	private Long memoId;
	private Long authorId;
	private String authorEmail; // 이후 authorEmailId로 변경하
	private String title;
	private String content;
	private Date createDate;
	private Date updateDate;
	
	@Builder
	public GetAllMemo_res_dto(Long memoId, Long authorId, String authorEmail, String title, String content, Date createDate,
			Date updateDate) {
		this.memoId = memoId;
		this.authorId = authorId;
		this.authorEmail = authorEmail;
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	
	
}
