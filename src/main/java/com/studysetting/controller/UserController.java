package com.studysetting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.studysetting.domain.user.UserEntity;
import com.studysetting.domain.user.UserRepository;
import com.studysetting.domain.user.dto.Login_req_dto;

@Controller
public class UserController {

  @Autowired
  UserRepository userRepo;

  @PostMapping("/login")
  public String login(@ModelAttribute("loginParam") Login_req_dto loginParam, RedirectAttributes rediAttr) {

    try {
      UserEntity userData = userRepo.findByUserEmail(loginParam.getUserEmail()).get();
      if (loginParam.getUserPassword().equals(userData.getUserPassword())) {
        rediAttr.addFlashAttribute("isLogined", true);
      }
    } catch (Exception e) {
      System.out.println("아무도 오지않는 깊은 산속에" + e.toString());
    }
    return "redirect:/";
  }
}
