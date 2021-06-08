package dmy.notice.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dmy.notice.service.DmyNoticeService;
import dmy.notice.vo.DmyNoticeVO;

@Controller
public class DmyNoticeController {
	
	private static Logger log = Logger.getLogger(DmyNoticeController.class);
	
	@Autowired
	private DmyNoticeService dmyNoticeService;
	
	@RequestMapping("noticeList")
	public ModelAndView noticeList(@ModelAttribute DmyNoticeVO param, HttpServletRequest req) {
//		if(req.getParameter("dpg_curPage")!= null && req.getParameter("dpg_curPage").length() > 0) {
//			param.setDpg_curPage(req.getParameter("dpg_curPage"));
//		}else {
//			param.setDpg_curPage("1");
//		}
//		
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
	
	@RequestMapping(value="writeClick" , method=RequestMethod.POST)
	public ModelAndView listNoticeWrite(@ModelAttribute("param") DmyNoticeVO param,HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		String message = "";
		HttpSession session = request.getSession(false);
		if(session != null) {
		mv.setViewName("notice/dmyNoticeInsertForm");
		}else {
			message =  "세션이 만료되었습니다. 로그인을 해주세요.";
			mv.addObject("message",message);
			mv.setViewName("login/loginForm");
		}
		return mv;
	}
	
	@RequestMapping(value="insertClick", method=RequestMethod.POST)
	public ModelAndView listNoticeInsert(@ModelAttribute DmyNoticeVO param, HttpServletRequest request) {
		log.info(param.getDnt_subject());
		log.info(param.getDnt_content());
		log.info(param.getDnt_file());
		log.info("request.getContentType() >>> " + request.getContentType());
		
		int size = 10*1024*1024;
		String path = "C:\\00.KOSMO78\\100.Project\\DMYweb\\DMY\\WebContent\\WEB-INF\\file";
		String[] type = {"jpg","png","gif","psd","tiff","jpeg"};
		
		try {
			MultipartRequest multi = new MultipartRequest(request,path,size,"UTF-8",new DefaultFileRenamePolicy());
			
			String dnt_subject = multi.getParameter("dnt_subject");
			String dnt_content = multi.getParameter("dnt_content");
			String dnt_file = null;
			
			param.setDnt_subject(dnt_subject);
			param.setDnt_content(dnt_content);
			
			Enumeration<String> et = multi.getFileNames();
			
			List<String> list = new ArrayList<String>();
			
			while(et.hasMoreElements()) {
				String file = et.nextElement();
				list.add(multi.getFilesystemName(file));
			}
			
			for(int i = 0; i<list.size(); i++) {
				dnt_file = list.get(i);
			}
			
			param.setDnt_file(dnt_file);
			
		} catch (Exception e) {
			log.info("오류 >>> : " + e.getMessage());		
		}
		
		String resultStr = "";
		int result = dmyNoticeService.noticeInsert(param);
		log.info(result);
		if(result>0) resultStr="성공";
		else resultStr="실패";
		
		ModelAndView mv = new ModelAndView();
		String message = "";
		HttpSession session = request.getSession(false);
		if(session != null) {
			mv.addObject("result", resultStr);
			mv.setViewName("notice/result");
		}else {
			message =  "세션이 만료되었습니다. 로그인을 해주세요.";
			mv.addObject("message",message);
			mv.setViewName("login/loginForm");
		}
		
		return mv;
	}
	
}



