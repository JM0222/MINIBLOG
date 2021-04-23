package com.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jblog.repository.BlogDao;
import com.jblog.vo.BlogVo;
import com.jblog.vo.CateVo;
import com.jblog.vo.PostVo;
@Service
public class BlogServiceImpl implements BlogService {
	@Autowired
	BlogDao blogDaoImpl;
	@Override
	public boolean update(BlogVo vo) {
		int updatedCount = blogDaoImpl.update(vo);
		return 1 == updatedCount;
	}
	@Override
	public BlogVo getBlogId(String id) {
		BlogVo vo = blogDaoImpl.getBlogId(id);
		return vo;
	}
	@Override
	public BlogVo getBlogNo(Long no) {
		BlogVo vo = blogDaoImpl.getBlogNo(no);
		return vo;
	}
	@Override
	public List<CateVo> getCategory(Long no) {
		List<CateVo> list = blogDaoImpl.getCategory(no);
		return list;
	}
	@Override
	public boolean insert(CateVo vo) {
		int insertedCount = blogDaoImpl.insertCate(vo);
		return 1 == insertedCount;
	}
	@Override
	public List<PostVo> getPost(Long no) {
		List<PostVo> list = blogDaoImpl.getPost(no);
		return list;
	}
	@Override
	public boolean insert(PostVo vo) {
		int insertedPostCount = blogDaoImpl.insertPost(vo);
		return 1 == insertedPostCount;
	}
	@Override
	public BlogVo getMain(String id) {
		BlogVo vo = blogDaoImpl.getMain(id);
		return vo;
	}
	@Override
	public boolean delete(Long no) {
		int deletedCount = blogDaoImpl.delete(no);
		return 1 == deletedCount;
	}

}
