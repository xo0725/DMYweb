package dmy.signup.chabun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dmy.signup.chabun.dao.ChabunDAO;
import dmy.signup.vo.DmySignUpVO;


@Service
@Transactional
public class ChabunServiceImpl implements ChabunService {

	@Autowired
	private ChabunDAO chabunDAO;
	
	@Override
	public DmySignUpVO getSignUpChabun() {
		// TODO Auto-generated method stub
		DmySignUpVO svo = chabunDAO.getSignUpChabun();
		return svo;
	}

}
