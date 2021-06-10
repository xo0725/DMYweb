package dmy.signup.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dmy.signup.dao.DmySignUpMapper;
import dmy.signup.vo.DmySignUpVO;

@Service
@Transactional
public class DmySignUpServiceImpl implements DmySignUpService {
	private static Logger logger = Logger.getLogger(DmySignUpServiceImpl.class);
	
	@Autowired(required = false)
	private DmySignUpMapper dmySignUpMapper;
	
	
	
	// 신청 목록
	@Override
	public List<DmySignUpVO> listSignUp(DmySignUpVO svo) {
		// TODO Auto-generated method stub
		System.out.println("DmySignUpServiceImpl listSignUp 시작!!!");
		logger.info("DmySignUpServiceImpl listSignUp 시작!!!");
		logger.info("listSignUp svo >>> : " + svo);
		
		List<DmySignUpVO> list = dmySignUpMapper.listSignUp(svo);
		
		logger.info("listSignUp >>> : " + list);
		logger.info("DmySignUpServiceImpl listSignUp 끝!!!");
		System.out.println("DmySignUpServiceImpl listSignUp 끝!!!");
		return list;
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

	// 매칭 신청
	@Override
	public int signUpMatch(DmySignUpVO svo) {
		// TODO Auto-generated method stub
		logger.info("DmySignUpServiceImpl signUpMatch 시작!!!");
		logger.info("signUpMatch svo >>> : " + svo);
		
		int nCnt = dmySignUpMapper.signUpMatch(svo);
		
		logger.info("signUpMatch >>> : " + nCnt);
		logger.info("DmySignUpServiceImpl signUpMatch 끝!!!");
		
		return nCnt;
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
