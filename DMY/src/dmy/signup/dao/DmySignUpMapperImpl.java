package dmy.signup.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dmy.signup.vo.DmySignUpVO;

@Repository
public class DmySignUpMapperImpl implements DmySignUpMapper {

	private Logger logger = Logger.getLogger(DmySignUpMapperImpl.class);
	
	@Autowired(required = false)
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<DmySignUpVO> listSignUp(DmySignUpVO svo) {
		// TODO Auto-generated method stub
		System.out.println("DmySignUpMapperImpl listSignUp !!!");
		logger.info("DmySignUpMapperImpl listSignUp !!!");
		
		
		return sqlSession.selectList("listSignUp");
	}

	@Override
	public List<DmySignUpVO> viewSinUpMatch(DmySignUpVO svo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DmySignUpVO viewSignUp(DmySignUpVO svo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DmySignUpVO> signUpCheckMatch(DmySignUpVO svo) {
		// TODO Auto-generated method stub
		return null;
	}

	// ¸ÅÄª ½ÅÃ»
	@Override
	public int signUpMatch(DmySignUpVO svo) {
		// TODO Auto-generated method stub
		System.out.println("DmySignUpMapperImpl signUpMatch !!!");
		logger.info("DmySignUpMapperImpl signUpMatch !!!");

		return (int)sqlSession.insert("signUpMatch");
	}

	@Override
	public int updateSignUp(DmySignUpVO svo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSignUp(DmySignUpVO svo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int acceptSignUp(DmySignUpVO svo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
