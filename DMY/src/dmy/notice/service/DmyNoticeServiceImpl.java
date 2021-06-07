package dmy.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dmy.notice.dao.DmyNoticeMapper;
import dmy.notice.vo.DmyNoticeVO;

@Service
@Transactional
public class DmyNoticeServiceImpl implements DmyNoticeService {

	final private DmyNoticeMapper dmyNoticeMapper;
	
	@Autowired(required=false)
	public DmyNoticeServiceImpl(DmyNoticeMapper dmyNoticeMapper) {
		this.dmyNoticeMapper = dmyNoticeMapper;
	}
	
	@Override
	public List<DmyNoticeVO> noticeList(DmyNoticeVO dnvo) {
		List<DmyNoticeVO> noticeList = null;
		System.out.println("service");
		noticeList = dmyNoticeMapper.noticeList(dnvo);
		
		return noticeList;
	}

	@Override
	public int noitceInsert(DmyNoticeVO dnvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DmyNoticeVO noticeListDetail(DmyNoticeVO param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int noticeUpdate(DmyNoticeVO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int noticeDelete(DmyNoticeVO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int noticeViewCnt(DmyNoticeVO param) {
		// TODO Auto-generated method stub
		return 0;
	}

}
