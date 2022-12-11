package com.studysetting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studysetting.domain.memo.dto.MemoEntity;
import com.studysetting.domain.memo.dto.MemoRepository;

@Controller
// @RestController
public class MemoController {

	@Autowired
	MemoRepository repo;
	
	
	@GetMapping("/")
	public String getAllMemo(Model model) {
		model.addAttribute("memoList", repo.findAll());
		return "home";
	}
}
