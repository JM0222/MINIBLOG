package com.jblog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jblog.service.BlogService;
import com.jblog.vo.BlogVo;
import com.jblog.vo.MemberVo;

@Controller
@RequestMapping("/")
public class BlogController {
	
	@Autowired
	BlogService blogServiceImpl;
	
	@RequestMapping("{id}/admin/basic")
	public String adminBasic(@PathVariable("id") String id,
			HttpSession session, Model model) {
		BlogVo vo = blogServiceImpl.getBlogId(id);
		model.addAttribute("vo",vo);
		MemberVo authUser = (MemberVo)session.getAttribute("authUser");
		if (authUser == null) {
			return "redirect:/";
		} else if (authUser.getUserNo() != vo.getUserNo()) {	
			return "redirect:/";
		}
		return "board/write";
	}
	@RequestMapping(value = "{id}/admin/basic",
			method = RequestMethod.POST)
	public String adminBasicAction(@ModelAttribute BlogVo updatedVo) {
		BlogVo vo = blogServiceImpl.getBlogNo(updatedVo.getUserNo());
		vo.setBlogTitle(updatedVo.getBlogTitle());
		
		boolean success = blogServiceImpl.update(vo);
		return "redirect:/{id}";
		
	}

}
