package com.studysetting.service;

import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {
  // @ResponseBody
  // @ModelAttribute
  @ExceptionHandler(NoSuchElementException.class)
  public String invailedArgumentsHandler() {
    // redirect.addFlashAttribute("ExceptionMessage", "값 입력 오류");
    return "redirect:/";
  }
}
