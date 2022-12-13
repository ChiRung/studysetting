package com.studysetting.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
  
  public void getMemoList() {
    ArrayList<MemoEntity> memoEntities = (ArrayList<MemoEntity>) memoRepo.findAll();
    ArrayList<GetAllMemo_res_dto> memoDtos = new ArrayList<GetAllMemo_res_dto>();
    // to Dto

    System.out.println("입 벌려라 메모 들어간다. : \n" + memoRepo.findAll());
    System.out.println("입 벌려라 댓글 들어간다. : \n" + commentRepo.findAll());
    // System.out.println(memoDtos.addAll(memoEntities));
    // memoDtos.addAll(memoEntities);
    // ArrayList<GetAllMemo_res_dto> memoDtos = memoEntities.stream().map(m -> new GetAllMemo_res_dto)
    // System.out.println(memoEntities.stream().);
    
    // List<String> abc =
    // memoRepo.findAll().stream().map(memo -> memo.getTitle()).collect(Collectors.toList());

    memoRepo.findAll().

  }


  // public HomeDataGetter(MemoRepository memoRepo) {
  //   this.memoRepo = memoRepo;
  //   // this.commentRepo = commentRepo;
  // }

}
