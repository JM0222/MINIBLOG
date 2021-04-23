package com.jblog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jblog.service.BlogService;
import com.jblog.service.MemberService;
import com.jblog.vo.BlogVo;
import com.jblog.vo.CateVo;
import com.jblog.vo.MemberVo;
import com.jblog.vo.PostVo;

@Controller
public class MainController {
	@Autowired
	BlogService blogServiceImpl;
	
	@RequestMapping({ "/", "/main" })
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		return mav;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String bloghome(@PathVariable("id") String id,
			HttpSession session, Model model) {
		BlogVo vo = blogServiceImpl.getBlogId(id);
		model.addAttribute("vo", vo);
		System.out.println(vo);
		
		List<PostVo> postList = blogServiceImpl.getPost(vo.getUserNo());
		model.addAttribute("postList", postList);
		  
		List<CateVo> cateList = blogServiceImpl.getCategory(vo.getUserNo());
		model.addAttribute("cateList", cateList);
		
		return "/board/list";
	}
	
	  @RequestMapping(value = "{id}", method=RequestMethod.POST) 
	  public String bloghomeAction(@PathVariable("/{id}") String id,
	  @RequestParam(value = "cateNo",required=false, defaultValue = "") 
	  	Long cateNo, HttpSession session, Model model) { 
		  
		  BlogVo vo = blogServiceImpl.getMain(id); 
		  model.addAttribute("vo", vo); 
		  List<PostVo> postList = blogServiceImpl.getPost(vo.getUserNo());
		  List<PostVo> newList = new ArrayList<>();
		  
		  for(PostVo e: postList) {
			  if (e.getCateNo() == cateNo) {
				  newList.add(e);
			  }
		  }
		  model.addAttribute("postList", newList);
	  
		  List<CateVo> cateList = blogServiceImpl.getCategory(vo.getUserNo());
		  model.addAttribute("cateList", cateList);
	  
	  return "/board/list"; 
	  
	  }

	 

}
