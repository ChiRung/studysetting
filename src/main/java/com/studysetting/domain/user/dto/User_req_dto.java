package com.studysetting.domain.user.dto;

import com.studysetting.domain.user.UserEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Builder
@Setter
@Getter
public class User_req_dto {
  private Long userId;
  private String userEmail;
  private String userPassword;

  @Builder
  public User_req_dto(Long userId, String userEmail, String userPassword) {
    this.userId = userId;
    this.userEmail = userEmail;
    this.userPassword = userPassword;
  }

  public UserEntity toEntity() {
    return UserEntity.builder().userEmail(userEmail).userPassword(userPassword).build();
  }
}
