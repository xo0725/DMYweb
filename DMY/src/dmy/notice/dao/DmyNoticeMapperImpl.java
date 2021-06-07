package dmy.notice.dao;

import java.util.List;

import dmy.notice.vo.DmyNoticeVO;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DmyNoticeMapperImpl extends SqlSessionDaoSupport implements DmyNoticeMapper {

	@Override
	public List<DmyNoticeVO> noticeList(DmyNoticeVO dnvo) {
		System.out.println("MapperImpl 진입");
		List<DmyNoticeVO> list = getSqlSession().selectList("noticeList");
		System.out.println("여기도");
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
