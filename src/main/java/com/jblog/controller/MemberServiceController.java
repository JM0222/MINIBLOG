package com.jblog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jblog.service.MemberService;
import com.jblog.vo.BlogVo;
import com.jblog.vo.CateVo;
import com.jblog.vo.MemberVo;

@Controller
@RequestMapping("/members")
public class MemberServiceController {
	@Autowired
	private MemberService memberService;
	@RequestMapping(value= {"","/","/join"},
			method=RequestMethod.GET)
	public String join() {
		return "users/joinform";
	}
	
	@RequestMapping(value ="/join",
			method=RequestMethod.POST)
	public String joinAction(@ModelAttribute MemberVo memberVo,
			BlogVo blogVo, CateVo cateVo) {
		System.out.println("폼전송된 데이터"+ memberVo);
		System.out.println("폼전송된 데이터2"+ blogVo);
		boolean success = memberService.join(memberVo);
		if (success) {
			memberService.joinBlog(blogVo);
			memberService.joinCate(cateVo);
			System.out.println("가입 성공");
			return "redirect:/members/joinsuccess";
		} else {
			System.out.println("가입 실패");
			return "redirect:/members/";
		}
	}
	@RequestMapping("/joinsuccess")
	public String joinSuccess() {
		return "users/joinsuccess";
	}
	
//	중복 이메일 체크
	@ResponseBody
	@RequestMapping("/idcheck")
	public Object existsid(
			@RequestParam(value="id", required=false, defaultValue="") String id) {
		MemberVo vo = memberService.getUser(id);
		boolean exists = vo != null ? true: false;	//	vo 객체가 null -> 이미 존재하는 사용자
		
		//	결과 MAP -> 컨버터 -> JSON 변환
		Map<String, Object> map = new HashMap<>();
		map.put("result", "success");
		map.put("data", exists);
		
		return map;
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() {
		return "users/loginform";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginAction(
			@RequestParam String id,
			@RequestParam String password,

			HttpSession session) {	//	사용자 세션 저장을 위한 세션 객체

		MemberVo authUser = memberService.getUser(id, password);
		
		//	만약에 찾는 유저가 없으면 login 폼으로 되돌려보냄
		if (authUser != null) {
			//	세션에 추가
			session.setAttribute("authUser", authUser);
			//	홈페이지로 리다이렉트
			return "redirect:/";
		} else {
			//	로그인 실패
			return "redirect:/members/login";
		}
	
	}
	// 로그아웃
		@RequestMapping("/logout")
		public String logoutAction(HttpSession session) {
			// 세션 지우기 
			session.removeAttribute("authUser");
			// 세션 무효화
			session.invalidate();
			return "redirect:/";
		}

		/*
		 * @RequestMapping(value="/{id}", method=RequestMethod.GET) public String
		 * bloghome(@PathVariable("id") String id, Model model) {
		 * model.addAttribute("id", id); return "/board/list"; }
		 */
		
}
