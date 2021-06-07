package dmy.notice.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import dmy.notice.vo.DmyNoticeVO;

@Repository
public class DmyNoticeMapperImpl extends SqlSessionDaoSupport implements DmyNoticeMapper {

	private static Logger log = Logger.getLogger(DmyNoticeMapperImpl.class);
	
	@Override
	public List<DmyNoticeVO> noticeList(DmyNoticeVO param) {
		List<DmyNoticeVO> list = getSqlSession().selectList("noticeList");
		log.info(list);
		return list;
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
