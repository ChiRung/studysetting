package com.studysetting.controller;

import java.util.ArrayList;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studysetting.domain.comment.CommentRepository;

@Controller
public class CommentController {

  @Autowired
  CommentRepository commentRepo;

  @GetMapping("/comment/{memoId}")
  // public void getComment(@RequestParam("memoId") Long memoId) {
    public String getComment(@PathVariable("memoId") Long memoId) {
    // commentRepo.findByMemoId(memoId);
    // findA
    System.out.println(commentRepo.findAllByMemoId(memoId));
    // System.out.println(memoId);
    return "redirect:/";
  }

  // @PostMapping("/comment/add")
  // public String addComment(@ModelAttribute("newComment") ) {
    
  // }
}
