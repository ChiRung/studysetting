package com.studysetting.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.studysetting.domain.user.UserEntity;
import com.studysetting.domain.user.UserRepository;
import com.studysetting.domain.user.dto.User_req_dto;

@SessionAttributes(names = { "isLogined", "userId", "userEmail" }) // 이 이름들로 model에 addAttribute할 때 세션에도 저장하라고 명시
@Controller
public class UserController {

  @Autowired
  UserRepository userRepo;

  @PostMapping("/login")
  public String login(@ModelAttribute("loginParam") User_req_dto loginParam, HttpServletRequest request,
      HttpServletResponse response) {

    UserEntity userData = userRepo.findByUserEmail(loginParam.getUserEmail()).get();
    if (loginParam.getUserPassword().equals(userData.getUserPassword())) {
      HttpSession session = request.getSession();
      session.setMaxInactiveInterval(1800);
      session.setAttribute("isLogined", true);
      session.setAttribute("userId", userData.getUserId());
      session.setAttribute("userEmail", userData.getUserEmail());
    }
    return "redirect:/";
  }

  @PostMapping("/signUp")
  public String signUp(@ModelAttribute("loginParam") User_req_dto loginParam, RedirectAttributes redirect) {
    if (userRepo.findByUserEmail(loginParam.getUserEmail()).isPresent()) {
      // 이미 회원가입 된 경우의 핸들링
      redirect.addFlashAttribute("error", "이미 가입된 이메일입니다.");
    } else {
      redirect.addFlashAttribute("message", "회원가입이 완료되었습니다.");
      userRepo.save(loginParam.toEntity());
    }
    return "redirect:/";
  }

  @GetMapping("/logout")
  public String logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
    Cookie[] cookies = httpServletRequest.getCookies();
    if (cookies != null) {
      for (int i = 0; i < cookies.length; i++) {
        cookies[i].setMaxAge(0);
        httpServletResponse.addCookie(cookies[i]);
      }
    }

    return "redirect:/";
  }
}
