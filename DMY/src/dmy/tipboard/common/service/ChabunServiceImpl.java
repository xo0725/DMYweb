package dmy.tipboard.common.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dmy.tipboard.common.dao.ChabunDAO;
import dmy.tipboard.vo.DmyTipBoardVO;

@Service
@Transactional
public class ChabunServiceImpl implements ChabunService {
	private Logger logger = Logger.getLogger(ChabunServiceImpl.class);
	
	private ChabunDAO chabunDAO;
	
	@Autowired(required=false)
	public ChabunServiceImpl(ChabunDAO chabunDAO) {
		this.chabunDAO = chabunDAO;
	}

	@Override
	public DmyTipBoardVO getBoardChabun() {
		// TODO Auto-generated method stub
		return chabunDAO.getBoardChabun();
	}


}
