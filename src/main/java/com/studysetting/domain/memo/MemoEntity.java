package com.studysetting.domain.memo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.studysetting.domain.comment.CommentEntity;
import com.studysetting.domain.memo.dto.GetAllMemo_res_dto;
import com.studysetting.domain.memo.dto.PatchMemo_req_dto;

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

	private String title;

	private String content;

	private Long authorId;

	private String authorEmail;

	@CreatedDate
	private LocalDate createDate;

	@LastModifiedDate
	private LocalDate updateDate;

	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "memoId")
	private List<CommentEntity> comment = new ArrayList<>();

	@Builder
	public MemoEntity(Long memoId, Long authorId, String title, String authorEmail, String content, LocalDate createDate,
	LocalDate updateDate) {
		this.memoId = memoId;
		this.authorId = authorId;
		this.authorEmail = authorEmail;
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public PatchMemo_req_dto to_PatchMemo_req_dto() {
		return PatchMemo_req_dto.builder()
				.memoId(memoId)
				.title(title)
				.content(content)
				.build();
	}

	public GetAllMemo_res_dto toGetAllMemo_res_dto() {
		return GetAllMemo_res_dto.builder()
		.memoId(memoId)
		.title(title)
		.content(content)
		.comment(comment)
		.authorEmail(authorEmail)
		.authorId(authorId)
		.build();
	}

	public void update(String title, String content) {
		this.title = title;
		this.content = content;
	}
}