package com.studysetting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studysetting.domain.memo.dto.MemoEntity;
import com.studysetting.domain.memo.dto.MemoRepository;

@RestController
public class MemoController {

	@Autowired
	MemoRepository repo;
	
	
	@GetMapping("/")
	public List<MemoEntity> getAllMemo() {
		return repo.findAll();
	}
}
