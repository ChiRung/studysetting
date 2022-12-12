package com.studysetting.domain.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class User_res_dto {
  private Long userId;
  private String userEmail;

  @Builder
  public User_res_dto(Long userId, String userEmail) {
    this.userId = userId;
    this.userEmail = userEmail;
  }

}
