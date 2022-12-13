package com.studysetting.domain.comment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Builder
@Getter
@Entity(name = "comment")
public class CommentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long commentId;

  private Long memoId;

  private Long authorId;

  private String authorEmail;

  private String content;

  @CreatedDate
  private LocalDate createDate;

  @Builder
  public CommentEntity(Long memoId, Long authorId, String authorEmail, String content) {
    this.memoId = memoId;
    this.authorId = authorId;
    this.authorEmail = authorEmail;
    this.content = content;
  }

}
