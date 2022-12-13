package com.studysetting.domain.memo;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.studysetting.domain.comment.CommentEntity;
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
	private Date createDate;

	@LastModifiedDate
	private Date updateDate;

	@OneToMany
	@JoinColumn(name = "memoId") //
	private List<CommentEntity> comment = new ArrayList<>(); // 생성자는 arraylist인데 타입은 list? interface가 타입이 될 수 있나?

	@Builder
	public MemoEntity(Long memoId, Long authorId, String title, String authorEmail, String content, Date createDate, Date updateDate) {
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

	public void update(String title, String content) {
		this.title = title;
		this.content = content;
	}

	// public ArrayList<GetAllMemo_res_dto> to_GetAllMemo_res_dto_list(ArrayList<MemoEntity> memoEntities) {
	// 	//
	// }
}