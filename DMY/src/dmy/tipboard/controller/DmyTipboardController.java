package dmy.tipboard.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dmy.tipboard.common.ChabunUtil;
import dmy.tipboard.common.service.ChabunService;
import dmy.tipboard.service.DmyTipBoardService;
import dmy.tipboard.vo.DmyTipBoardVO;

@Controller
public class DmyTipboardController {

	private static Logger log = Logger.getLogger(DmyTipboardController.class);
	
	private DmyTipBoardService boardService;
	private ChabunService chabunService;
	
	// 생성자 Autowired 
	@Autowired(required=false)	
	public DmyTipboardController( DmyTipBoardService boardService
			               ,ChabunService chabunService) {
		this.boardService = boardService;
		this.chabunService = chabunService;
	}	

	@Autowired
	private DmyTipBoardService dmyTipBoardService;

/*======================================================게시판목록======================================================*/	
	
	//팁공유게시판 목록 조회(마이페이지용)-------------------------------------------------------------------------------------------------

	
	@RequestMapping("/board")
	public String board() {
		log.info("DmyTipBoardController mylistboard >>>");
		return "tipboard/board";
	}
	@RequestMapping("/mylistboard")
	public ModelAndView mylistboard(@ModelAttribute DmyTipBoardVO param, HttpServletRequest request) {

		log.info("DmyTipBoardController mylistboard >>>");
		log.info("DmyTipBoardController mylistboard param >>> " + param);

		ModelAndView mav = new ModelAndView();
		DmyTipBoardVO searchVO = new DmyTipBoardVO();
		searchVO.setSearchFilter(param.getSearchFilter());
		searchVO.setKeyword(param.getKeyword());

		HttpSession session = request.getSession(false);
		if (session != null) {
			String Dmb_no = String.valueOf(session.getAttribute("Dmb_no"));
			if (Dmb_no != "null") {
				param.setdmb_no(Dmb_no);
				log.info("DmyTipBoardController mylistboard param.getDmb_no >>> " + param.getdmb_no());

			}
		}
		if (request.getParameter("dpg_curPage") != null && request.getParameter("dpg_curPage").length() > 0) {
			log.info("DmyTipBoardController mylistboard dpg_curPage >>>" + request.getParameter("dpg_curPage"));
			param.setdpg_curPage(request.getParameter("dpg_curPage"));
		} else {
			param.setdpg_curPage("1");
		}
		List<DmyTipBoardVO> mylistboard = dmyTipBoardService.mylistboard(param);
		mav.addObject("mylistboard", mylistboard);
		log.info("DmyTipBoardController mylistboard mav >>> " + mav);
		mav.addObject("searchVO", searchVO);
		mav.setViewName("myPage/mylistboard");
		return mav;
	}

	//팁공유게시판 목록 조회-------------------------------------------------------------------------------------------------

	@RequestMapping("/listboard")
	public ModelAndView listboard(@ModelAttribute DmyTipBoardVO param, HttpServletRequest request) {

		log.info("DmyTipBoardController listboard >>>");
		log.info("DmyTipBoardController listboard param >>> " + param);

		ModelAndView mav = new ModelAndView();
		DmyTipBoardVO searchVO = new DmyTipBoardVO();
		searchVO.setSearchFilter(param.getSearchFilter());
		searchVO.setKeyword(param.getKeyword());

		HttpSession session = request.getSession(false);
		if (session != null) {
			String Dmb_no = String.valueOf(session.getAttribute("Dmb_no"));
			if (Dmb_no != "null") {
				param.setdmb_no(Dmb_no);
				log.info("DmyTipBoardController listboard param.getDmb_no >>> " + param.getdmb_no());

			}
		}
		if (request.getParameter("dpg_curPage") != null && request.getParameter("dpg_curPage").length() > 0) {
			log.info("DmyTipBoardController listboard dpg_curPage >>>" + request.getParameter("dpg_curPage"));
			param.setdpg_curPage(request.getParameter("dpg_curPage"));
		} else {
			param.setdpg_curPage("1");
		}
		List<DmyTipBoardVO> listboard = dmyTipBoardService.listboard(param);
		mav.addObject("listboard", listboard);
		log.info("DmyTipBoardController listboard mav >>> " + mav);
		mav.addObject("searchVO", searchVO);
		mav.setViewName("tipboard/listboard");
		return mav;
	}

	//팁공유게시판 전체목록 조회-------------------------------------------------------------------------------------------------
	@RequestMapping("/listallboard")
	public ModelAndView listallboard(@ModelAttribute DmyTipBoardVO param, HttpServletRequest request) {

		log.info("DmyTipBoardController listallboard >>>");
		log.info("DmyTipBoardController listallboard param >>> " + param);

		ModelAndView mav = new ModelAndView();
		DmyTipBoardVO searchVO = new DmyTipBoardVO();
		searchVO.setSearchFilter(param.getSearchFilter());
		searchVO.setKeyword(param.getKeyword());

		HttpSession session = request.getSession(false);
		if (session != null) {
			String Dmb_no = String.valueOf(session.getAttribute("Dmb_no"));
			if (Dmb_no != "null") {
				param.setdmb_no(Dmb_no);
				log.info("DmyTipBoardController listallboard param.getDmb_no >>> " + param.getdmb_no());
			}
		}
		if (request.getParameter("dpg_curPage") != null && request.getParameter("dpg_curPage").length() > 0) {
			log.info("DmyTipBoardController listallboard dpg_curPage >>>" + request.getParameter("dpg_curPage"));
			param.setdpg_curPage(request.getParameter("dpg_curPage"));
		} else {
			param.setdpg_curPage("1");
		}
		List<DmyTipBoardVO> listallboard = dmyTipBoardService.listallboard(param);
		mav.addObject("listallboard", listallboard);
		log.info("DmyTipBoardController listallboard mav >>> " + mav);
		mav.addObject("searchVO", searchVO);
		mav.setViewName("tipboard/listallboard");
		return mav;
	}

	/*======================================================게시판상세목록======================================================*/
	//등록버튼 클릭시 이동-------------------------------------------------------------------------------------------------
	@RequestMapping("/insertForm")
	public ModelAndView insertForm(@ModelAttribute DmyTipBoardVO param, HttpServletRequest request) {
		log.info("DmyTipBoardController insertForm >>> ");
		log.info("DmyTipBoardController insertForm param >>> " + param);

		String message = "";
		ModelAndView mav = new ModelAndView();

		HttpSession session = request.getSession(false);
		if (session != null) {
			String Dmb_no = String.valueOf(session.getAttribute("Dmb_no"));
			if (Dmb_no != "null") {
				param.setdmb_no(Dmb_no);
				log.info("DmyTipBoardController insertForm param.getDmb_no >>> " + param.getdmb_no());
				mav.addObject("Dmb_no", Dmb_no);

			} else {
				message = "세션이 만료되었습니다. 로그인을 해주세요.";
				mav.addObject("message", message);
				mav.setViewName("login/loginForm");
			}
		}
		mav.setViewName("tipboard/insertboard");
		return mav;
	}// end of insertForm

	//수정 비밀번호 체크
	@RequestMapping("updatepwCheck")
	public ModelAndView updatepwCheck(@ModelAttribute DmyTipBoardVO param) {
		log.info("DmyTipBoardController updatepwCheck >>> ");
		log.info("DmyTipBoardController updatepwCheck param >>> " + param);
		log.info("DmyTipBoardController updatepwCheck param.getDtb_pw >>> " + param.getdtb_pw());

		ModelAndView mav = new ModelAndView();
		List<DmyTipBoardVO> detailboard = dmyTipBoardService.detailboard(param);
		mav.addObject("detailboard", detailboard);
		mav.setViewName("tipboard/updatepwCheck");

		return mav;
	}

	//삭제 비밀번호 체크
	@RequestMapping("deletepwCheck")
	public ModelAndView deletepwCheck(@ModelAttribute DmyTipBoardVO param) {
		log.info("DmyTipBoardController deletepwCheck >>> ");
		log.info("DmyTipBoardController deletepwCheck param >>> " + param);
		log.info("DmyTipBoardController deletepwCheck param.getDtb_pw >>> " + param.getdtb_pw());

		ModelAndView mav = new ModelAndView();
		List<DmyTipBoardVO> detailboard = dmyTipBoardService.detailboard(param);
		mav.addObject("detailboard", detailboard);
		mav.setViewName("tipboard/deletepwCheck");

		return mav;
	}

	//수정버튼 클릭시 이동-------------------------------------------------------------------------------------------------
	@RequestMapping("/updateForm")
	public ModelAndView updateForm(@ModelAttribute DmyTipBoardVO param, HttpServletRequest request) {
		log.info("DmyTipBoardController updateForm >>> ");
		log.info("DmyTipBoardController updateForm param >>> " + param);
		log.info("DmyTipBoardController updateForm param.getDtb_no >>> " + param.getdtb_no());

		ModelAndView mav = new ModelAndView();
		String message = "";
		HttpSession session = request.getSession(false);
		if (session != null) {
			String Dmb_no = String.valueOf(session.getAttribute("Dmb_no"));
			if (Dmb_no != "null") {
				param.setdmb_no(Dmb_no);
				List<DmyTipBoardVO> detailboard = dmyTipBoardService.detailboard(param);
				mav.addObject("detailboard", detailboard);
				mav.setViewName("tipboard/updateboard");
			} else {
				message = "세션이 만료되었습니다. 로그인을 해주세요.";
				mav.addObject("message", message);
				mav.setViewName("login/loginForm");
			}
		}
		mav.setViewName("tipboard/updateboard");
		return mav;
	}// end of updateForm

	//삭제버튼 클릭시 이동-------------------------------------------------------------------------------------------------
	@RequestMapping("/deleteForm")
	public ModelAndView deleteForm(@ModelAttribute DmyTipBoardVO param, HttpServletRequest request) {
		log.info("DmyTipBoardController deleteForm >>> ");
		log.info("DmyTipBoardController updateForm param >>> " + param);

		ModelAndView mav = new ModelAndView();
		String message = "";
		HttpSession session = request.getSession(false);
		if (session != null) {
			String Dmb_no = String.valueOf(session.getAttribute("Dmb_no"));
			if (Dmb_no != "null") {
				param.setdmb_no(Dmb_no);
				List<DmyTipBoardVO> detailboard = dmyTipBoardService.detailboard(param);
				mav.addObject("detailboard", detailboard);
				mav.setViewName("tipboard/deleteboard");
			} else {
				message = "세션이 만료되었습니다. 로그인을 해주세요.";
				mav.addObject("message", message);
				mav.setViewName("login/loginForm");
			}
		}

		mav.setViewName("tipboard/deleteboard");
		return mav;
	}// end of deleteForm

	//게시판상세페이지 이동 -------------------------------------------------------------------------------------------------
	@RequestMapping("/detailboard")
	public ModelAndView detailboard(@ModelAttribute DmyTipBoardVO param, HttpServletRequest request) {

		log.info("DmyTipBoardController detailboard >>> ");
		log.info("DmyTipBoardController detailboard param >>> " + param);
		log.info("DmyTipBoardController detailboard param.Dtb_no >>> " + param.getdtb_no());

		ModelAndView mav = new ModelAndView();

		HttpSession session = request.getSession(false);
		if (session != null) {
			String Dmb_no = String.valueOf(session.getAttribute("Dmb_no"));
			if (Dmb_no != "null") {
				param.setdmb_no(Dmb_no);
				log.info("DmyTipBoardController login param.getDmb_no >>> " + param.getdmb_no());

				// 조회수
				int nCntViewCount = dmyTipBoardService.viewcntboard(param);
				log.info("DmyTipBoardController nCntViewCount >>> " + nCntViewCount);

				// 좋아요
				String sgd_goodyn = "";
				String session_no = param.getdmb_no();
				log.info("DmyTipBoardController detailboard session_no >>> " + session_no);

				List<DmyTipBoardVO> goodYNboardList = dmyTipBoardService.goodYNboard(param);
				param.setSession_no(session_no);

				if (goodYNboardList.size() == 1) {
					sgd_goodyn = goodYNboardList.get(0).getdgd_goodyn();
					log.info("1 >>> sgd_goodyn >>>" + sgd_goodyn);
				} else if (goodYNboardList.size() == 0) {
					sgd_goodyn = "N";
					log.info("0 >>> sgd_goodyn >>>" + sgd_goodyn);
				}
				param.setdgd_goodyn(sgd_goodyn);

				List<DmyTipBoardVO> detailboard = dmyTipBoardService.detailboard(param);
				param.setSession_no(session_no);
				mav.addObject("detailboard", detailboard);
				mav.setViewName("tipboard/detailboard");
			} else {
				mav.addObject("result","세션이 만료되었습니다. 로그인을 해주세요.");
				mav.setViewName("login/loginForm");
			}
		}
		return mav;
	}

	/*======================================================게시판등록======================================================*/
	//팁공유게시판 등록-------------------------------------------------------------------------------------------------
	@RequestMapping("/insertboard")
	public String insertboard(HttpServletRequest request, DmyTipBoardVO param) {
		log.info("DmyTipBoardController insertboard >>> ");

		// 채번 구하기
		String dtb_no= ChabunUtil.getTipBoardChabun("N", chabunService.getBoardChabun().getdtb_no());
		log.info("DmyTipBoardController insertboard dtb_no >>> : " + dtb_no);
		

		
		int size = 10 * 1024 * 1024;
		String path = "C:\\00.KOSMO78\\100.project\\DMYweb\\DMY\\WebContent\\WEB-INF\\file";

		log.info("request.getContentType()" + request.getContentType());

		
		
		try {
			MultipartRequest mult = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());

			String dmb_no = mult.getParameter("dmb_no");
			String dtb_category = mult.getParameter("dtb_category");
			String dtb_subject = mult.getParameter("dtb_subject");
			String dtb_pw = mult.getParameter("dtb_pw");
			String dtb_shareyn = mult.getParameter("dtb_shareyn");
			String dtb_content = mult.getParameter("dtb_content");
			String dtb_file = "";

			log.info("dmb_no >>> : " + dmb_no);
			log.info("dtb_category >>> : " + dtb_category);
			log.info("dtb_subject >>> : " + dtb_subject);
			log.info("dtb_pw >>> : " + dtb_pw);
			log.info("dtb_shareyn >>> : " + dtb_shareyn);
			log.info("dtb_content >>> : " + dtb_content);
			log.info("dtb_file >>> : " + dtb_file);
			param.setdtb_no(dtb_no);
			param.setdmb_no(dmb_no);
			param.setdtb_category(dtb_category);
			param.setdtb_subject(dtb_subject);
			param.setdtb_pw(dtb_pw);
			param.setdtb_shareyn(dtb_shareyn);
			param.setdtb_content(dtb_content);

			Enumeration<String> em = mult.getFileNames();

			List<String> list = new ArrayList<String>();

			while (em.hasMoreElements()) {
				String file = em.nextElement();
				list.add(mult.getFilesystemName(file));
			}

			for (int i = 0; i < list.size(); i++) {
				dtb_file = list.get(i);
			}

			param.setdtb_file(dtb_file);

		} catch (Exception e) {
			log.info("에러 >>> " + e.getMessage());
		}

		int result = 0;
		String url = "";

		result = dmyTipBoardService.insertboard(param);
		if (result == 1) {
			log.info("insert 성공  >>> " + result);
		} else {
			log.info("insert 실패  >>> " + result);
		}
		url = "/listboard.dmy";

		return "redirect:" + url;
	}// end of insertboard

	//첨부파일 다운로드-------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/boardFileDownload")
	public ModelAndView boardFileDownload(@ModelAttribute DmyTipBoardVO param) {
		log.info("DmyTipBoardController boardFileDownload >>> 다운로드 진행중 페이지로 이동");

		String path = "C:\\00.KOSMO78\\100.project\\DMYweb\\DMY\\WebContent\\WEB-INF\\file";

		String file = param.getdtb_file();
		log.info("다운로드 할 파일명 >>> file : " + file);

		ModelAndView mav = new ModelAndView();
		mav.addObject("file", file);
		mav.addObject("path", path);
		mav.setViewName("tipboard/fileDownload");
		return mav;
	}// end of boardFileDownload


	/*======================================================게시판수정======================================================*/	
	//팁공유게시판 수정-------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/updateboard")
	public String updateboard(@ModelAttribute DmyTipBoardVO param, HttpServletRequest request) {
		log.info("DmyTipBoardController updateboard >>>");
		int size = 10 * 1024 * 1024;
		String path = "C:\\00.KOSMO78\\100.project\\DMYweb\\DMY\\WebContent\\WEB-INF\\file";

		log.info("request.getContentType()" + request.getContentType());

		try {
			MultipartRequest mult = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());

			String dtb_no = mult.getParameter("dtb_no");
			String dmb_no = mult.getParameter("dmb_no");
			String dtb_category = mult.getParameter("dtb_category");
			String dtb_subject = mult.getParameter("dtb_subject");
			String dtb_shareyn = mult.getParameter("dtb_shareyn");
			String dtb_content = mult.getParameter("dtb_content");
			String dtb_file = "";

			log.info(dtb_no);
			log.info(dtb_category);
			log.info(dtb_subject);
			log.info(dtb_shareyn);
			log.info(dtb_content);

			param.setdmb_no(dmb_no);
			param.setdtb_no(dtb_no);
			param.setdtb_category(dtb_category);
			param.setdtb_subject(dtb_subject);
			param.setdtb_shareyn(dtb_shareyn);
			param.setdtb_content(dtb_content);

			Enumeration<String> em = mult.getFileNames();

			List<String> list = new ArrayList<String>();

			while (em.hasMoreElements()) {
				String file = em.nextElement();
				if (mult.getFilesystemName(file) != null) {
					list.add(mult.getFilesystemName(file));
				}
			}

			for (int i = 0; i < list.size(); i++) {
				dtb_file = list.get(i);

				File f = new File(path + mult.getParameter("old_dtb_file"));
				boolean delete = f.delete();
				log.info("기존 첨부파일 삭제성공 >>>  delete >>>" + delete);
			}
			param.setdtb_file(dtb_file);

		} catch (Exception e) {
			log.info("에러 >>> " + e.getMessage());
		}

		int result = 0;
		String url = "";

		result = dmyTipBoardService.updateboard(param);
		if (result == 1) {
			log.info("update 성공  >>> " + result);
		} else {
			log.info("update 실패  >>> " + result);
		}
		url = "/listboard.dmy";

		return "redirect:" + url;
	}

	/*======================================================게시판삭제======================================================*/
	@RequestMapping("/deleteboard")
	public String deleteboard(@ModelAttribute DmyTipBoardVO param, HttpServletRequest request) {

		log.info("DmyTipBoardController deleteboard >>> ");
		log.info("DmyTipBoardController deleteboard param >>> " + param);
		log.info("delete :: param.getDtb_no() >>>" + param.getdtb_no());

		int size = 10 * 1024 * 1024;
		String path = "C:\\00.KOSMO78\\100.project\\DMYweb\\DMY\\WebContent\\WEB-INF\\file";

		try {
			MultipartRequest mult = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());

			String Dtb_no = mult.getParameter("Dtb_no");
			String Dtb_file = mult.getParameter("Dtb_file");
			log.info(Dtb_no);

			param.setdtb_no(Dtb_no);
			param.setdtb_file(Dtb_file);

			int nCntDelete = dmyTipBoardService.deleteboard(param);
			if (nCntDelete == 1) {
				log.info("삭제 성공 nCntDelete >>>" + nCntDelete);
				// 기존파일삭제성공
				File file = new File(path + Dtb_file);
				boolean deleteFile = file.delete();
				log.info("기존파일삭제성공 >>> " + deleteFile);
			} else {
				log.info("파일삭제실패 nCntDelete >>> " + nCntDelete);
			}

		} catch (Exception e) {
			log.info("에러 >>> " + e.getMessage());
		}

		String url = "/listboard.dmy";
		return "redirect:" + url;
	}

	/*======================================================게시판좋아요======================================================*/
	//좋아요 클릭 여부
	@ResponseBody
	@RequestMapping("/goodYNboard")
	public Map goodboard(@ModelAttribute DmyTipBoardVO param, HttpServletRequest request) {

		log.info("DmyTipBoardController goodboard >>> 추천완료후 상세보기 페이지로 이동");
		log.info("DmyTipBoardController goodboard param.getdtb_no >>> " + param.getdtb_no());
		log.info("DmyTipBoardController goodboard param.getdmb_no >>> " + param.getdmb_no());
		log.info("DmyTipBoardController goodboard param.getMy_goodyn >>> " + param.getMy_goodyn());
		log.info("DmyTipBoardController goodboard param.getSession_no >>> " + param.getSession_no());

		String goodYNboard = "";
		String goodboardResult = "";
		String Dtb_no = param.getdtb_no();
		String my_goodyn = param.getMy_goodyn();

		HttpSession session = request.getSession(false);
		if (session != null) {
			String Dmb_no = String.valueOf(session.getAttribute("Dmb_no"));
			if (Dmb_no != "null") {
				param.setSession_no(Dmb_no);
					if("N".equals(param.getMy_goodyn())) {
						log.info("my_goodyn N일 경우 insert하기 if문 >>>");
						
						param.setdtb_no(Dtb_no);
						int nCntinsertgoodcnt = dmyTipBoardService.insertgoodcnt(param);
						
						if(nCntinsertgoodcnt == 1) {
							log.info("좋아요 성공 >>> nCntinsertgoodcnt >>>" + nCntinsertgoodcnt);
						}else {
							log.info("좋아요 실패 nCntinsertgoodcnt >>> " + nCntinsertgoodcnt);
							goodboardResult = "좋아요 실패.. 잠시 후 다시 시도해 주세요";
						}
					
					}else if("Y".equals(param.getMy_goodyn())) {
						log.info("0건이 아닐경우 update하기  >>>");
									
						//2-2. 좋아요 여부 조회 결과, 값이 'N'일 경우 -> 'Y'로 변경
						log.info("좋아요 취소 상태 -> 좋아요상태로 변경");
							 
						param.setdtb_no(Dtb_no);				
						int nCntupdategoodN = dmyTipBoardService.updategoodN(param);
						
						if(nCntupdategoodN == 1) {
							log.info("좋아요 성공 >>> " +nCntupdategoodN);
							goodboardResult = "좋아요 성공!!";
						}else {
							log.info("좋아요 실패 nCntupdategoodN >>> " + nCntupdategoodN);
							goodboardResult = "좋아요 실패.. 잠시 후 다시 시도해 주세요";
						}		
				   }//end of n->y
				}
			}
		List<DmyTipBoardVO> boardDetailList = dmyTipBoardService.detailboard(param);
		DmyTipBoardVO stvo = boardDetailList.get(0);
		log.info(stvo.getMy_goodyn());
		log.info(stvo.getdtb_goodcnt());
		Map<String, String> m = new HashMap<String, String>();

		m.put("result", goodboardResult);
		m.put("my", stvo.getMy_goodyn());
		m.put("cnt", stvo.getdtb_goodcnt());

		return m;
	}

}// end of DmyTipBoardController
