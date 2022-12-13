package com.studysetting.domain.comment.dto;

import com.studysetting.domain.comment.CommentEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Post_comment_req_dto {
  private Long memoId;
  private Long authorId;
  private String authorEmail;
  private String content;

  @Builder
  public Post_comment_req_dto(Long memoId, Long authorId, String content) {
    this.memoId = memoId;
    this.authorId = authorId;
    this.content = content;
  }

  public CommentEntity toEntity() {
    return CommentEntity.builder()
    .memoId(memoId)
    .authorId(authorId)
    .authorEmail(authorEmail)
    .content(content)
    .build();
  }
}
