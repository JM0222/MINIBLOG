package com.jblog.repository;

import com.jblog.vo.BlogVo;
import com.jblog.vo.CateVo;
import com.jblog.vo.MemberVo;

public interface MemberDao {
	public int insert(MemberVo vo);
	public int insertBlog(BlogVo vo);
	public int insertCate(CateVo vo);
	public MemberVo selectUser(String id, String password);
	public MemberVo selectUser(String id);
}
