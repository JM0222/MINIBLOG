package com.jblog.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jblog.exception.MemberDaoException;
import com.jblog.vo.BlogVo;
import com.jblog.vo.CateVo;
import com.jblog.vo.MemberVo;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(MemberVo vo) {
		int insertedCount = 0;
		try {
			insertedCount = sqlSession.insert("members.insert",vo);
		}catch(Exception e) {
			throw new MemberDaoException("회원가입오류",vo);
		}
		return insertedCount;
	}

	@Override
	public MemberVo selectUser(String id, String password) {
		Map<String, String> userMap = new HashMap<>();
		userMap.put("id", id);
		userMap.put("password", password);
		MemberVo vo = sqlSession.selectOne("members.selectUserByNameAndPassword",userMap);
		return vo;
	}

	@Override
	public MemberVo selectUser(String id) {
		MemberVo vo = sqlSession.selectOne("members.selectUserByName",id);
		return vo;
	}

	@Override
	public int insertBlog(BlogVo vo) {
		int insertedCount2 = sqlSession.insert("members.insertBlog",vo);
		return insertedCount2;
	}

	@Override
	public int insertCate(CateVo vo) {
		int insertedCount3 = sqlSession.insert("members.insertCate",vo);
		return insertedCount3;
	}






}
