package com.jblog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jblog.service.BlogService;
import com.jblog.service.FileUploadService;
import com.jblog.vo.BlogVo;
import com.jblog.vo.CateVo;
import com.jblog.vo.MemberVo;
import com.jblog.vo.PostVo;

@Controller
@RequestMapping("/")
public class BlogController {
	
	@Autowired
	BlogService blogServiceImpl;
	
	
	@RequestMapping("{id}/admin/basic")
	public String adminBasic(@PathVariable("id") String id,
			HttpSession session, Model model) {
		MemberVo authUser = (MemberVo)session.getAttribute("authUser");
		BlogVo vo = blogServiceImpl.getBlogId(id);
		model.addAttribute("vo",vo);
		if (authUser == null) {
			return "redirect:/";
		} else if (authUser.getUserNo() != vo.getUserNo()) {	
			return "redirect:/";
		}
		return "board/write";
	}
	@Autowired
	FileUploadService fileUploadService;
	@RequestMapping(value = "{id}/admin/update",
			method = RequestMethod.POST)
	public String adminBasicAction(@ModelAttribute BlogVo updatedVo,
			@RequestParam MultipartFile uploadfile, Model model) {
		BlogVo vo = blogServiceImpl.getBlogNo(updatedVo.getUserNo());
		vo.setBlogTitle(updatedVo.getBlogTitle());
		String saveFilename = fileUploadService.store(uploadfile);
		String urlImage = "upload-images/" + saveFilename;
		vo.setLogoFile(urlImage);
		boolean success = blogServiceImpl.update(vo);
		return "redirect:/{id}";
	}


	//############################################################
	
	@RequestMapping("{id}/admin/category")
	public String adminCategory(@PathVariable("id") String id,
			HttpSession session, Model model) {
		MemberVo authUser = (MemberVo)session.getAttribute("authUser");
		if (authUser == null) {
			return "redirect:/";
		}
		List<CateVo> list = blogServiceImpl.getCategory(authUser.getUserNo());
		model.addAttribute("list", list);
		return "board/category";
	}
	@RequestMapping(value="{id}/admin/category",
			method = RequestMethod.POST)
	public String adminCategoryAction(@ModelAttribute CateVo insertVo,
		HttpSession session, Model model){
			MemberVo authUser = (MemberVo)session.getAttribute("authUser");
			if (authUser == null) {
				return "redirect:/";
			}
			model.addAttribute("authUser", authUser);
			boolean success = blogServiceImpl.insert(insertVo);
			return "redirect:/{id}";
	}
	
	@RequestMapping(value="{id}/admin/delete",
			method = RequestMethod.POST)
	public String adminDeleteAction(@RequestParam("no") Long no,
			HttpSession session, Model model) {
		MemberVo vo = (MemberVo)session.getAttribute("authUser");
		model.addAttribute("authUser", vo);
		boolean success = blogServiceImpl.delete(no);
		return "redirect:/{id}/admin/category";
		
	}
	
		
	//############################################################
	@RequestMapping("{id}/admin/post")
	public String adminPost(@PathVariable("id") String id,
			HttpSession session, Model model) {
		MemberVo authUser = (MemberVo)session.getAttribute("authUser");
		if (authUser == null) {
			return "redirect:/";
		}
		List<CateVo> list = blogServiceImpl.getCategory(authUser.getUserNo());
		model.addAttribute("list", list);
		return "board/post";
	}
	@RequestMapping(value="{id}/admin/post",
			method = RequestMethod.POST)
	public String adminPostAction(@ModelAttribute PostVo vo,
			HttpSession session, Model model) {
			MemberVo authUser = (MemberVo)session.getAttribute("authUser");
			if (authUser == null) {
				return "redirect:/";
			}
			model.addAttribute("authUser", authUser);
			boolean success = blogServiceImpl.insert(vo);
			return "redirect:/{id}";
	}
	
	
	

}
