package com.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jblog.vo.BlogVo;
@Repository
public class BlogDaoImpl implements BlogDao {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int update(BlogVo vo) {
		int updatedCount = sqlSession.update("blogs.update", vo);
		return updatedCount;
	}

	@Override
	public BlogVo getBlogId(String id) {
		BlogVo vo = sqlSession.selectOne("blogs.getBlogId",id);
		return vo;
	}

	@Override
	public BlogVo getBlogNo(Long no) {
		BlogVo vo = sqlSession.selectOne("blogs.getBlogNo",no);
		return vo;
	}

}
