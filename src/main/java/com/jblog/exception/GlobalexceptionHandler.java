package com.jblog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
@ControllerAdvice
public class GlobalexceptionHandler {
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(MemberDaoException.class)
	public ModelAndView handleMemberDaoException(MemberDaoException e) {
		// 로그 기록
		System.err.println("MemberDaoException:" + e.getMessage());
		e.printStackTrace();
		// 에외 상황 정보 로깅
		System.err.println("MemberVo:" + e.getMemberVo());
		// 안내 화면
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", e.getClass().getSimpleName());
		mav.addObject("message",e.getMessage());
		mav.setViewName("error/exception");
		
		return mav;
	}
}
