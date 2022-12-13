package com.studysetting.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.studysetting.domain.comment.CommentEntity;
import com.studysetting.domain.comment.CommentRepository;
import com.studysetting.domain.memo.MemoEntity;
import com.studysetting.domain.memo.MemoRepository;
import com.studysetting.domain.memo.dto.GetAllMemo_res_dto;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
public class HomeDataGetter {

  @Autowired
  MemoRepository memoRepo;

  @Autowired
  CommentRepository commentRepo;

  // private MemoRepository memoRepo;
  
  public void getMemoList(Model model) {
    ArrayList<MemoEntity> memoEntities = (ArrayList<MemoEntity>) memoRepo.findAll();
  
    System.out.println("입 벌려라 메모 들어간다. : \n" + memoRepo.findAll());
    System.out.println("입 벌려라 댓글 들어간다. : \n" + commentRepo.findAll());
    // System.out.println(memoDtos.addAll(memoEntities));
    // memoDtos.addAll(memoEntities);
    // ArrayList<GetAllMemo_res_dto> memoDtos = memoEntities.stream().map(m -> new GetAllMemo_res_dto)
    // System.out.println(memoEntities.stream().);
    
    // List<String> abc =
    // memoRepo.findAll().stream().map(memo -> memo.getMemoId()).collect(Collectors.toList());
    
    // List<String> abc = memoRepo.findAll().stream().map(memo -> memo.getComment().get(0)).collect(Collectors.toList())
    // System.out.println("idontknow" + abc);


    for (MemoEntity m : memoEntities) {
      // System.out.println(m.getComment());
      for (CommentEntity c : m.getComment()) {
        System.out.println(c.getContent());
      }
    }



    model.addAttribute("memoList", memoEntities);

  }


  // public HomeDataGetter(MemoRepository memoRepo) {
  //   this.memoRepo = memoRepo;
  //   // this.commentRepo = commentRepo;
  // }

}
