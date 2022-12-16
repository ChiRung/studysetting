package com.studysetting.domain.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.studysetting.domain.user.dto.User_req_dto;
import com.studysetting.domain.user.dto.User_res_dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Getter
@Entity(name = "user")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;

  @NonNull
  @Column(length = 35)
  private String userEmail;

  @NonNull
  @Column(length = 35)
  private String userPassword;

  @CreatedDate
  private Date createDate;

  @Builder
  public UserEntity(String userEmail, String userPassword) {
    this.userEmail = userEmail;
    this.userPassword = userPassword;
  }

  public User_res_dto to_User_res_dto() {
    return User_res_dto.builder()
    .userId(userId)
    .userEmail(userEmail)
    .build();
  }
}
