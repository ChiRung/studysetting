package com.studysetting.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studysetting.domain.memo.MemoEntity;
import com.studysetting.domain.memo.MemoRepository;
import com.studysetting.domain.memo.dto.PatchMemo_req_dto;
import com.studysetting.domain.memo.dto.PostMemo_req_dto;
import com.studysetting.domain.user.dto.User_req_dto;
import com.studysetting.service.HomeDataGetter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MemoController {

	@Autowired
	MemoRepository memoRepo;

	private final HomeDataGetter homeDataGetter;

	/**
	 * root 페이지 이동
	 */
	@GetMapping("/")
	public String getHomePage(Model model) {
		User_req_dto login_req_dto = new User_req_dto();
		model.addAttribute("loginParam", login_req_dto);
		PostMemo_req_dto postMemo_req_dto = new PostMemo_req_dto();
		model.addAttribute("newComment", postMemo_req_dto);

		homeDataGetter.getMemoList(model);
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
	@PostMapping("/addMemo")
	public String postMemo(@ModelAttribute("newMemo") PostMemo_req_dto newMemo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		newMemo.setAuthorId((Long) session.getAttribute("userId"));
		newMemo.setAuthorEmail((String) session.getAttribute("userEmail"));
		memoRepo.save(newMemo.toEntity());
		return "redirect:/";
	}

	/**
	 * memo 수정 페이지 이동
	 */
	@GetMapping("/modify")
	public String getModifyMemoPage(Model model, @RequestParam("memoId") Long memoId) {
		PatchMemo_req_dto memoData = memoRepo.findById(memoId).get().to_PatchMemo_req_dto();
		model.addAttribute("memoData", memoData);
		return "modifyMemo";
	}

	/**
	 * memo 수정
	 */
	@PostMapping("/modify")
	public String modifyMemo(@ModelAttribute("memoData") PatchMemo_req_dto patchMemo_req_dto) {
		MemoEntity modifyData = memoRepo.findById(patchMemo_req_dto.getMemoId()).get();
		modifyData.update(patchMemo_req_dto.getTitle(), patchMemo_req_dto.getContent());
		memoRepo.save(modifyData);
		return "redirect:/";
	}

	/**
	 * memo 삭제
	 */
	@GetMapping("/deleteMemo")
	public String deleteMemo(@RequestParam("memoId") Long memoId) {
		memoRepo.deleteById(memoId);
		return "redirect:/";
	}

	@GetMapping("/download")
	public void downloadMemo(HttpServletResponse response, Model model) {
		homeDataGetter.getMemoList(model);
		ArrayList<MemoEntity> memoList = (ArrayList<MemoEntity>) model.getAttribute("memoList");
		
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet0 = workbook.createSheet("Sheet0"); // 이거 타입 변경해서 잘 될지 몰루?
		Row row = null;
		Cell cell = null;
		int rowNum = 0;

		// excel sheet header
		row = sheet0.createRow(rowNum++);
		cell = row.createCell(0);
		cell.setCellValue("memo_id");
		cell = row.createCell(1);
		cell.setCellValue("title");
		cell = row.createCell(2);
		cell.setCellValue("content");
		cell = row.createCell(3);
		cell.setCellValue("author_id");
		cell = row.createCell(4);
		cell.setCellValue("author_email");
		cell = row.createCell(5);
		cell.setCellValue("createDate");
		cell = row.createCell(6);
		cell.setCellValue("updateDate");

		// excel sheet body
		for (MemoEntity memo : memoList) {
			row = sheet0.createRow(rowNum++);
			cell = row.createCell(0);
			cell.setCellValue(memo.getMemoId());
			cell = row.createCell(1);
			cell.setCellValue(memo.getTitle());
			cell = row.createCell(2);
			cell.setCellValue(memo.getContent());
			cell = row.createCell(3);
			cell.setCellValue(memo.getAuthorId());
			cell = row.createCell(4);
			cell.setCellValue(memo.getAuthorEmail());
			cell = row.createCell(5);
			cell.setCellValue(memo.getCreateDate().toString());
			cell = row.createCell(6);
			cell.setCellValue(memo.getUpdateDate().toString());
		}
		
		// 컨텐츠 타입과 파일명 지정
		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition", "attachment;filename=studysetting.xls");

		try {
			workbook.write(response.getOutputStream());
			workbook.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
