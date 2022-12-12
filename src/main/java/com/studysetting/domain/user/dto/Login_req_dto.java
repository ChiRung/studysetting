package com.studysetting.domain.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Builder
@Setter
@Getter
public class Login_req_dto {
  private String userEmail;
  private String userPassword;

  @Builder
  public Login_req_dto(String userEmail, String userPassword) {
    this.userEmail = userEmail;
    this.userPassword = userPassword;
  }
}
