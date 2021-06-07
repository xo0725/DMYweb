package dmy.notice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dmy.notice.service.DmyNoticeService;
import dmy.notice.vo.DmyNoticeVO;

@Controller
public class DmyNoticeController {
	
	@Autowired
	private DmyNoticeService dmyNoticeService;
	
	@RequestMapping(value="listNotice")
	public ModelAndView listNotice(@ModelAttribute DmyNoticeVO param, HttpServletRequest req) {
		if(req.getParameter("dpg_curPage")!= null && req.getParameter("dpg_curPage").length() > 0) {
			param.setDpg_curPage(req.getParameter("dpg_curPage"));
		}else {
			param.setDpg_curPage("1");
		}
		
		DmyNoticeVO searchVO = new DmyNoticeVO();
		searchVO.setSearchFilter(param.getSearchFilter());
		searchVO.setKeyword(param.getKeyword());
		
		ModelAndView mv = new ModelAndView();
		String message = "";
		HttpSession session = req.getSession(false);
		if(session != null) {
			List<DmyNoticeVO> list = dmyNoticeService.noticeList(param);
			mv.addObject("noticeList", list);
			mv.addObject("searchVO", searchVO);
			mv.setViewName("notice/dmyNoticeListAll");
		}else {
			message = "세션이 만료되었습니다. 로그인 해주세요.";
			mv.addObject("message", message);
			mv.setViewName("login/loingForm");
		}
		return mv;
	}
	
	@RequestMapping("noticeListAll")
	public String noticeListAll() {
		
		System.out.println("noticeListAll 진입");
		
		return "notice/dmyNoticeListAll";
	}
	
}
