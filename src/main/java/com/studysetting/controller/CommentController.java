package com.studysetting.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studysetting.domain.comment.CommentRepository;
import com.studysetting.domain.comment.dto.Post_comment_req_dto;

@Controller
public class CommentController {

  @Autowired
  CommentRepository commentRepo;

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
