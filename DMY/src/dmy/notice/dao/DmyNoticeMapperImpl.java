package dmy.notice.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dmy.notice.vo.DmyNoticeVO;

@Repository
public class DmyNoticeMapperImpl implements DmyNoticeMapper {

	private static Logger log = Logger.getLogger(DmyNoticeMapperImpl.class);
	
   @Autowired(required = false)
   private SqlSessionTemplate sqlSession;
	
	@Override
	public List<DmyNoticeVO> noticeList(DmyNoticeVO param) {
		List<DmyNoticeVO> list = sqlSession.selectList("noticeList");
		log.info(list);
		
		return list;
	}

	@Override
	public int noticeInsert(DmyNoticeVO dnvo) {
		return (int)sqlSession.insert("noticeInsert");
	}

	@Override
	public DmyNoticeVO noticeListDetail(DmyNoticeVO param) {
		log.info("mapperImpl noticeListDetail ÁøÀÔ >>>> ");
		
		return (DmyNoticeVO)sqlSession.selectOne("noticeListDetail");
	}

	@Override
	public int noticeUpdate(DmyNoticeVO param) {
		return (int)sqlSession.update("noticeUpdate");
	}

	@Override
	public int noticeDelete(DmyNoticeVO param) {
		return (int)sqlSession.update("noticeDelete");
	}

	@Override
	public int noticeViewCnt(DmyNoticeVO param) {
		return (int)sqlSession.update("noticeViewCount");
	}

}
