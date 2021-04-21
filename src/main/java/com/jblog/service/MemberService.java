package com.jblog.service;

import com.jblog.vo.BlogVo;
import com.jblog.vo.CateVo;
import com.jblog.vo.MemberVo;

public interface MemberService {
	public boolean join(MemberVo vo); // 가입 (INSERT)
	public boolean joinBlog(BlogVo vo);
	public boolean joinCate(CateVo vo);
	public MemberVo getUser(String id, String password); // 로그인
	public MemberVo getUser(String id); // 중복아이디 체크
}
