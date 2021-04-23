package com.jblog.service;

import java.util.List;

import com.jblog.vo.BlogVo;
import com.jblog.vo.CateVo;
import com.jblog.vo.PostVo;

public interface BlogService {
	public boolean update(BlogVo vo); // 게시물 업데이트
	public BlogVo getBlogId(String id);
	public BlogVo getBlogNo(Long no);
	
	//#######################################
	public List<CateVo> getCategory(Long no);
	public boolean insert(CateVo vo);
	
	//#######################################
	public List<PostVo> getPost(Long no);
	public boolean insert(PostVo vo);
	
	//#######################################
	public BlogVo getMain(String id);
	
	//#######################################
	public boolean delete(Long no);
}
