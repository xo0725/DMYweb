package dmy.tipboard.service;

import java.util.List;

import dmy.tipboard.vo.DmyTipBoardVO;



public interface DmyTipBoardService {

	  //내가쓴글 목록(마이페이지용)
			public List<DmyTipBoardVO> mylistboard(DmyTipBoardVO param);
			
		   //게시판목록
			public List<DmyTipBoardVO> listboard(DmyTipBoardVO param);
			
			//게시판목록(관리자용)
			public List<DmyTipBoardVO> listallboard(DmyTipBoardVO param);
			
			//게시판상세보기
			public List<DmyTipBoardVO> detailboard(DmyTipBoardVO param);
			
			//게시판등록
			public int insertboard(DmyTipBoardVO param);
			
			//게시판수정
			public int updateboard(DmyTipBoardVO param);
			
			//게시판삭제
			public int deleteboard(DmyTipBoardVO param);
			
			//조회수증가
			public int viewcntboard(DmyTipBoardVO param);
			
			//=======게시판 글 좋아요구현=========
			//1. 좋아요 클릭여부 조회
			public List<DmyTipBoardVO> goodYNboard(DmyTipBoardVO param);
			
			//2-1.좋아요 클릭여부  조회 후 0 건이면 insert 하기
			public int insertgoodcnt(DmyTipBoardVO param);
			
			//2-2.좋아요 클릭여부 조회 결과 , 값이 'N'일 경우 'Y'로 변경하기
			//public int updategoodY(DmyTipBoardVO param);
			
			//2-3.좋아요 클릭여부 조회 결과 , 값이 'Y'일 경우 'N'으로 변경하기
			public int updategoodN(DmyTipBoardVO param);
		

}
