package com.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jblog.repository.MemberDao;
import com.jblog.vo.BlogVo;
import com.jblog.vo.CateVo;
import com.jblog.vo.MemberVo;
@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDao memberDao;
	@Override
	public boolean join(MemberVo vo) {
		int insertedCount = memberDao.insert(vo);
		return insertedCount == 1;
	}

	@Override
	public MemberVo getUser(String id, String password) {
		MemberVo vo = memberDao.selectUser(id, password);
		return vo;
	}

	@Override
	public MemberVo getUser(String id) {
		MemberVo vo = memberDao.selectUser(id);
		return vo;
	}

	@Override
	public boolean joinBlog(BlogVo vo) {
		int insertedCount2 = memberDao.insertBlog(vo);
		return insertedCount2 == 1;
	}

	@Override
	public boolean joinCate(CateVo vo) {
		int insertedCount3 = memberDao.insertCate(vo);
		return insertedCount3 == 1;
	}





}
