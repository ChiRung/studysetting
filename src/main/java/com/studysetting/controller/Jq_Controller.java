package com.studysetting.controller;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studysetting.domain.comment.CommentRepository;
import com.studysetting.domain.comment.dto.Post_comment_req_dto;
import com.studysetting.domain.memo.MemoRepository;
import com.studysetting.domain.memo.dto.GetAllMemo_res_dto;
import com.studysetting.domain.user.UserRepository;
import com.studysetting.domain.user.dto.User_req_dto;
import com.studysetting.domain.user.dto.User_res_dto;

@RestController
public class Jq_Controller {
  @Autowired
  MemoRepository memoRepo;

  @Autowired
  CommentRepository commentRepo;

  @Autowired
  UserRepository userRepo;

  @GetMapping("/getAllMemo")
  public List<GetAllMemo_res_dto> getJqHome() {
    List<GetAllMemo_res_dto> memoList = memoRepo.findAll().stream().map(memo -> memo.toGetAllMemo_res_dto()).collect(Collectors.toList());
    return memoList;
  }


  @PostMapping("/jq/login")
  public User_res_dto getJqLogin(User_req_dto loginParam) {
    return userRepo.findByUserEmail(loginParam.getUserEmail()).get().to_User_res_dto();
  }
  
  @PostMapping("/jq/addComment")
  public HashMap<String, String> postJqComment(Post_comment_req_dto comment) {
    HashMap<String, String> resObject = new HashMap<String, String>();
    try {
      commentRepo.save(comment.toEntity());
      resObject.put("message", "success");
    } catch (Exception e) {
      resObject.put("message", "failed");
    }
    return resObject;
  }
}
