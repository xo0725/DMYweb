package dmy.tipboard.common.dao;


import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dmy.tipboard.vo.DmyTipBoardVO;

@Repository
public class ChabunDAOImpl implements ChabunDAO {
	private Logger logger = Logger.getLogger(ChabunDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;
	
	@Override
	public DmyTipBoardVO getBoardChabun() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("getBoardChabun");
	}

}
