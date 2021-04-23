package com.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jblog.vo.BlogVo;
import com.jblog.vo.CateVo;
import com.jblog.vo.PostVo;
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
		BlogVo vo = sqlSession.selectOne("blogs.getBlogId", id);
		return vo;
	}

	@Override
	public BlogVo getBlogNo(Long no) {
		BlogVo vo = sqlSession.selectOne("blogs.getBlogNo", no);
		return vo;
	}

	@Override
	public List<CateVo> getCategory(Long no) {
		List<CateVo> list = sqlSession.selectList("blogs.getCategory", no);
		return list;
	}

	@Override
	public int insertCate(CateVo vo) {
		int insertedCount = sqlSession.insert("blogs.insertCate", vo);
		return insertedCount;
	}

	@Override
	public List<PostVo> getPost(Long no) {
		List<PostVo> list = sqlSession.selectList("blogs.getPost", no);
		return list;
	}

	@Override
	public int insertPost(PostVo vo) {
		int insertedPostCount = sqlSession.insert("blogs.post", vo);
		return insertedPostCount;
	}

	@Override
	public BlogVo getMain(String id) {
		BlogVo vo = sqlSession.selectOne("blogs.getBlogId", id);
		return vo;
	}

	@Override
	public int delete(Long no) {
		int deletedCount = sqlSession.delete("blogs.delete", no);
		return deletedCount;
	}

}
