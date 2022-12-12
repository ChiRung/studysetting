package com.studysetting.controller;

import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.studysetting.domain.user.UserEntity;
import com.studysetting.domain.user.UserRepository;
import com.studysetting.domain.user.dto.User_req_dto;

@Controller
public class UserController {

  @Autowired
  UserRepository userRepo;

  @PostMapping("/login")
  public String login(@ModelAttribute("loginParam") User_req_dto loginParam, RedirectAttributes rediAttr) {

    try {
      UserEntity userData = userRepo.findByUserEmail(loginParam.getUserEmail()).get();
      if (loginParam.getUserPassword().equals(userData.getUserPassword())) {
        System.out.println("로그인을 시도합니다.");
        System.out.println("이메일: " + loginParam.getUserEmail());
        System.out.println("비밀번호: " + loginParam.getUserPassword());
        rediAttr.addFlashAttribute("isLogined", true);
      }
    } catch (Exception e) {
      System.out.println("아무도 오지않는 깊은 산속에" + e.toString());
    }
    return "redirect:/";
  }

  @PostMapping("/signUp")
  public String signUp(@ModelAttribute("loginParam") User_req_dto loginParam) {
    System.out.println("회원가입 이메일: " + loginParam.getUserEmail());
    System.out.println("회원가입 비밀번호: " + loginParam.getUserPassword());
    System.out.println("엠띠엠띠" + userRepo.findByUserEmail(loginParam.getUserEmail()).isPresent());

    if (userRepo.findByUserEmail(loginParam.getUserEmail()).isPresent()) {
      // alert return 하기!
      // message title, content class 만들어서
      // addAttribute에 넣어서 보내기
    } else {
      userRepo.save(loginParam.toEntity());
    }
    return "redirect:/";
  }
}
