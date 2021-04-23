package com.jblog.repository;

import java.util.List;

import com.jblog.vo.BlogVo;
import com.jblog.vo.CateVo;
import com.jblog.vo.PostVo;

public interface BlogDao {
	public int update(BlogVo vo);
	public BlogVo getBlogId(String id);
	public BlogVo getBlogNo(Long no);
	
	//###############################
	public List<CateVo> getCategory(Long no);
	public int insertCate(CateVo vo);
	
	//###############################
	public List<PostVo> getPost(Long no);
	public int insertPost(PostVo vo);
	
	//###############################
	public BlogVo getMain(String id);
	
	//###############################
	public int delete(Long no);
}
