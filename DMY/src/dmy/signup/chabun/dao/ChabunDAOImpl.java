package dmy.signup.chabun.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dmy.signup.vo.DmySignUpVO;


@Repository
public class ChabunDAOImpl implements ChabunDAO {

	@Autowired(required = false)
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public DmySignUpVO getSignUpChabun() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("getSignUpChabun");
	}

}
