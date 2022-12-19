package com.studysetting.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.studysetting.domain.comment.CommentRepository;
import com.studysetting.domain.memo.MemoEntity;
import com.studysetting.domain.memo.MemoRepository;

@Service
public class HomeDataGetter {

  @Autowired
  MemoRepository memoRepo;

  @Autowired
  CommentRepository commentRepo;

  public void getMemoList(Model model) {
    ArrayList<MemoEntity> memoEntities = (ArrayList<MemoEntity>) memoRepo.findAll();
    model.addAttribute("memoList", memoEntities);
  }
}
