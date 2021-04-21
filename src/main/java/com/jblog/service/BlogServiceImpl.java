package com.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jblog.repository.BlogDao;
import com.jblog.vo.BlogVo;
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

}
