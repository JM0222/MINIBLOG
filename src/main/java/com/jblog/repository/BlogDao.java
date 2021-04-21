package com.jblog.repository;

import com.jblog.vo.BlogVo;

public interface BlogDao {
	public int update(BlogVo vo);
	public BlogVo getBlogId(String id);
	public BlogVo getBlogNo(Long no);
}
