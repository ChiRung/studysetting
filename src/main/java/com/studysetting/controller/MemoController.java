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
		PostMemo_res_dto postMemo_res_dto = new PostMemo_res_dto();
		model.addAttribute("newMemo", postMemo_res_dto);
		return "addMemo";
	}

	@PostMapping("/addMemo") // 타임리프 쪽에서 이 컨트롤러 찌를꺼임
	public String postMemo(@ModelAttribute("newMemo") PostMemo_res_dto postMemo_res_dto) {  // 여기에 res dto추가 @ModelAttribute("newMemo")
		System.out.println("호옹이afafafafahf");
		System.out.println(postMemo_res_dto.getTitle());
		System.out.println(postMemo_res_dto.getContent());
		return "redirect:/";
	}
}
