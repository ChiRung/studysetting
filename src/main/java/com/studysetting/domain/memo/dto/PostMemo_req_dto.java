package com.studysetting.domain.memo.dto;

import java.util.Date;

import com.studysetting.domain.memo.MemoEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PostMemo_req_dto {

  private Long memoId;
  private String title;
  private String content;
  private Long authorId;
  private String authorEmail;
  private Date createDate;
  private Date updateDate;

  @Builder
  public PostMemo_req_dto(String title, String content) {
    this.title = title;
    this.content = content;
  }

  public MemoEntity toEntity() {
    return MemoEntity.builder()
            .title(title)
            .content(content)
            .authorId(authorId)
            .authorEmail(authorEmail)
            .build();
  }
}
