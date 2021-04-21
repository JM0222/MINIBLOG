package com.jblog.service;

import com.jblog.vo.BlogVo;

public interface BlogService {
	public boolean update(BlogVo vo); // 게시물 업데이트
	public BlogVo getBlogId(String id);
	public BlogVo getBlogNo(Long no);
}
