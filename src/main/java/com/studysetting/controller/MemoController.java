package com.studysetting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.studysetting.domain.memo.MemoRepository;
import com.studysetting.domain.memo.dto.PostMemo_res_dto;

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
	public String getAddMemoPage(Model model) {
		PostMemo_res_dto postMemo_res_dto = new PostMemo_res_dto(); // dto 인스턴스 만들고
		model.addAttribute("newMemo", postMemo_res_dto); // 해당 dto 인스턴스에 데이터 넣어보내라고 addMemo페이지에 newMemo란 이름으로 전달한다.
		return "addMemo";
	}

	@PostMapping("/addMemo") // 타임리프 쪽에서 이 컨트롤러 찌를꺼임
	public String postMemo(@ModelAttribute("newMemo") PostMemo_res_dto newMemo) {
		repo.save(newMemo.toEntity());
		return "redirect:/";
	}
}
