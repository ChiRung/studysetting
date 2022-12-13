package com.studysetting.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studysetting.domain.comment.CommentEntity;
import com.studysetting.domain.comment.CommentRepository;
import com.studysetting.domain.comment.dto.Post_comment_req_dto;

@Controller
public class CommentController {

  @Autowired
  CommentRepository commentRepo;

  // @GetMapping("/comment/{memoId}")
  // // public void getComment(@RequestParam("memoId") Long memoId) {
  // public String getComment(@PathVariable("memoId") Long memoId,
  // @ModelAttribute("newComment") Post_comment_req_dto newComment) {
  // // commentRepo.findByMemoId(memoId);
  // // findA
  // // System.out.println(commentRepo.findAllByMemoId(memoId));
  // // System.out.println(memoId);
  // System.out.println(newComment.getContent());
  // return "redirect:/";
  // }

  /**
   * 댓글 등록
   */
  @PostMapping("/comment")
  public String addComment(@RequestParam("memoId") Long memoId,
      @ModelAttribute("newComment") Post_comment_req_dto newComment, HttpServletRequest request) {
    HttpSession session = request.getSession();
    newComment.setMemoId(memoId);
    newComment.setAuthorId((Long) session.getAttribute("userId"));
    newComment.setAuthorEmail((String) session.getAttribute("userEmail"));
    commentRepo.save(newComment.toEntity());

    return "redirect:/";
  }
}
