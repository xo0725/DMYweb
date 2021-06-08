package dmy.notice.dao;

import java.util.List;

import dmy.notice.vo.DmyNoticeVO;

public interface DmyNoticeMapper {
	public List<DmyNoticeVO> noticeList(DmyNoticeVO dnvo);
	public int noticeInsert(DmyNoticeVO dnvo);
	public DmyNoticeVO noticeListDetail(DmyNoticeVO param);
	public int noticeUpdate(DmyNoticeVO param);
	public int noticeDelete(DmyNoticeVO param);
	public int noticeViewCnt(DmyNoticeVO param);
}
