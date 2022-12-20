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
    // System.out.println("실행실행");
    // redirect.addFlashAttribute("ExceptionMessage", "잘가요");
    return "redirect:/";
  }
}
