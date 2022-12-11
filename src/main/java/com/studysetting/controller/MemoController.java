package com.studysetting.controller;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studysetting.domain.memo.MemoEntity;
import com.studysetting.domain.memo.MemoRepository;
import com.studysetting.domain.memo.dto.PatchMemo_req_dto;
import com.studysetting.domain.memo.dto.PostMemo_req_dto;

@Controller
// @RestController
public class MemoController {

	@Autowired
	MemoRepository repo;

	/**
	 * root 페이지 이동
	 */
	@GetMapping("/")
	public String getHomePage(Model model) {
		model.addAttribute("memoList", repo.findAll());
		return "home";
	}

	/**
	 * addMemo페이지 이동
	 */
	@GetMapping("/addMemo")
	public String getAddMemoPage(Model model) {
		PostMemo_req_dto postMemo_res_dto = new PostMemo_req_dto(); // dto 인스턴스 만들고
		model.addAttribute("newMemo", postMemo_res_dto); // 해당 dto 인스턴스에 데이터 넣어보내라고 addMemo페이지에 newMemo란 이름으로 전달한다.
		return "addMemo";
	}

	/**
	 * memo 등록
	 */
	@PostMapping("/addMemo") // 타임리프 쪽에서 이 컨트롤러 찌를꺼임
	public String postMemo(@ModelAttribute("newMemo") PostMemo_req_dto newMemo) {
		// System.out.println(memoData);
		
		// repo.save(newMemo.toEntity().update(memoData.getTitle(), memoData.getContent());
		// newMemo.toEntity().update(memoData.getTitle(), memoData.getContent());

		// MemoEntity originData = repo.findById(memoData.getMemoId()).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다."));
		// originData.update(null, null);
	
		repo.save(newMemo.toEntity());
		return "redirect:/";
	}

	@GetMapping("/modify")
	public String getModifyMemoPage(Model model, @RequestParam("memoId") Long memoId) {
		PatchMemo_req_dto memoData = repo.findById(memoId).get().to_PatchMemo_req_dto();
		model.addAttribute("memoData", memoData);
		return "modifyMemo";
		// return "redirect:/";
	}

@PostMapping("/modify")
public String modifyMemo(@ModelAttribute("memoData") PatchMemo_req_dto patchMemo_req_dto) {
	MemoEntity modifyData = repo.findById(patchMemo_req_dto.getMemoId()).get();
	modifyData.update(patchMemo_req_dto.getTitle(), patchMemo_req_dto.getContent());
	repo.save(modifyData);
	return "redirect:/";
}


	// /**
	//  * memo 수정 페이지 이동
	//  * @return 
	//  */
	// @GetMapping("/modifyMemo")
	// public String getModifyMemoPage(@RequestParam("memoId") Long memoId, Model model) {
	// 	repo.findById(memoId);
	// 	MemoEntity memoDetail = repo.findById(memoId).get();

	// 	PatchMemo_req_dto patchMemo_req_dto = PatchMemo_req_dto.builder()
	// 			.memoId(memoDetail.getMemoId())
	// 			.title(memoDetail.getTitle())
	// 			.content(memoDetail.getContent())
	// 			.build();

	// 	model.addAttribute("memoData", patchMemo_req_dto);
	// 	return "modifyMemo";
	// }

	// @PostMapping("/modifyMemo")
	// public String patchModifyMemo(@ModelAttribute("memoData") PatchMemo_req_dto memoData) {
	// 		System.out.println(memoData.getTitle());
	// 		return "redirect:/";
	// }

	/**
	 * memo 삭제
	 */
	@GetMapping("/deleteMemo")
	public String deleteMemo(@RequestParam("memoId") Long memoId) {
		repo.deleteById(memoId);
		return "redirect:/";
	}
}
