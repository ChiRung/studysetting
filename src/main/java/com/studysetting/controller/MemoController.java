package com.studysetting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studysetting.domain.memo.dto.MemoEntity;
import com.studysetting.domain.memo.dto.MemoRepository;

@Controller
// @RestController
public class MemoController {

	@Autowired
	MemoRepository repo;
	
	
	@GetMapping("/")
	public String getHomePage(Model model) {
		model.addAttribute("memoList", repo.findAll());
		return "home";
	}

	@GetMapping("/addMemo")
	public String getAddMemoPage() {
		return "addMemo";
	}

	// @PostMapping("/memo") // 타임리프 쪽에서 이 컨트롤러 찌를꺼임
	// public String postMemo(@ModelAttribute("newMemo")) {
		

	// 	return "mockup";
	// }
}
