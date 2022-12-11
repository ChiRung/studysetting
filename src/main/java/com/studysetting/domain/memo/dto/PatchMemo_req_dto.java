package com.studysetting.domain.memo.dto;

import com.studysetting.domain.memo.MemoEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Getter
public class PatchMemo_req_dto {
  
  private Long memoId;
  private String title;
  private String content;

  @Builder
  public PatchMemo_req_dto(Long memoId, String title, String content) {
    this.memoId = memoId;
    this.title = title;
    this.content = content;
  }


  public MemoEntity toEntity() { // 추후 로그인 추가에 따른 작성자 이름, 작성자 아이디 등 추가하기
    return MemoEntity.builder()
            .memoId(memoId)
            .title(title)
            .content(content)
            .build();
  }

  public String getTitle() {
    return this.title;
  }
}
