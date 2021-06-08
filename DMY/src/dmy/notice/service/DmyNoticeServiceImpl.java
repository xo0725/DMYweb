package dmy.notice.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dmy.notice.dao.DmyNoticeMapper;
import dmy.notice.vo.DmyNoticeVO;

@Service
@Transactional
public class DmyNoticeServiceImpl implements DmyNoticeService {

	Logger log = Logger.getLogger(DmyNoticeServiceImpl.class);
	
	@Autowired
	private DmyNoticeMapper dmyNoticeMapper;
	
	@Override
	public List<DmyNoticeVO> noticeList(DmyNoticeVO dnvo) {
		List<DmyNoticeVO> noticeList = null;
		noticeList = dmyNoticeMapper.noticeList(dnvo);
		
		return noticeList;
	}

	@Override
	public int noticeInsert(DmyNoticeVO dnvo) {
		log.info("serviceImple noticeInsert 호출성공 >>> : ");
		
		return dmyNoticeMapper.noticeInsert(dnvo);
	}

	@Override
	public DmyNoticeVO noticeListDetail(DmyNoticeVO param) {
		log.info("ServiceImpl noticeListDetail 진입 >>>");
		
		return dmyNoticeMapper.noticeListDetail(param);
	}

	@Override
	public int noticeUpdate(DmyNoticeVO param) {
		log.info("serviceImple noticeUpdate 호출성공 >>> : ");
		return dmyNoticeMapper.noticeUpdate(param);
	}

	@Override
	public int noticeDelete(DmyNoticeVO param) {
		return dmyNoticeMapper.noticeDelete(param);
	}

	@Override
	public int noticeViewCnt(DmyNoticeVO param) {
		log.info("ServiceImpl noticeViewCnt 진입 >>>");
		
		return dmyNoticeMapper.noticeViewCnt(param);
	}

}
