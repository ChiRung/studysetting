package com.studysetting.domain.memo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Getter
public class PostMemo_res_dto {
  private String title;
  private String content;

  @Builder
  public PostMemo_res_dto(String title, String content) {
    this.title = title;
    this.content = content;
  }
}
