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
// @NoArgsConstructor
@Getter
public class PostMemo_req_dto {

  private Long memoId; // 테스트용
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

  public MemoEntity toEntity() { // 추후 로그인 추가에 따른 작성자 이름, 작성자 아이디 등 추가하기
    return MemoEntity.builder()
            .title(title)
            .content(content)
            .authorId(authorId)
            .authorEmail(authorEmail)
            .build();
  }
}
