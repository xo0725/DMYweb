package dmy.signup.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import dmy.common.ChabunUtil;
import dmy.signup.chabun.service.ChabunService;
import dmy.signup.service.DmySignUpService;
import dmy.signup.vo.DmySignUpVO;

@Controller
public class DmySignUpController {
	private Logger logger = Logger.getLogger(DmySignUpController.class);
	
	private ChabunService chabunService;
	
	/* @Autowired
	private Dmymatch spoMatchService;
	
	@Autowired
	private SpoChatService spoChatService; */
	
	@Autowired(required = false)
	private DmySignUpService dmySignUpService;
	
	@RequestMapping(value = "listSignUp", method = RequestMethod.GET)
	public String listSignUp(DmySignUpVO svo, Model model) {
		System.out.println("DmySignUpController listSignUp 함수 진입 성공!!");
		logger.info("DmySignUpController listSignUp 함수 진입 성공!!");
		
		// 페이지 이동 보류
		
		
		List<DmySignUpVO> list = dmySignUpService.listSignUp(svo);
		logger.info("DmySignUpController listSignUp >>> : " + list);
		
		model.addAttribute("list", list);
		
		System.out.println("DmySignUpController listSignUp 함수 끝!!");
		logger.info("DmySignUpController listSignUp 함수 끝!!");
		return "listSignUp"; // 총합할때 디렉토리 수정
	}
	
	
	
	
	
	
	// 신청하기 insert
	@RequestMapping(value = "signUpMath", method = RequestMethod.GET)
	public String signUpMatch(DmySignUpVO svo, HttpServletRequest req) {
		System.out.println("DmySignUpController signUpMatch 함수 진입 성공!!");
		logger.info("DmySignUpController signUpMatch 함수 진입 성공!!" + svo);
		
		int result = dmySignUpService.signUpMatch(svo);
		
		String resultStr = "";
		//String resultPage = "";
		
		// 채번 셋팅
		String dsu_no = ChabunUtil.getSignUpChabun("SM", chabunService.getSignUpChabun().getDsu_no());
		logger.info("DmySignUpController insert dsu_no >>> : " + dsu_no);
		svo.setDsu_no(dsu_no);
		
		logger.info("DmySignUpController signUpMatch svo.getDsu_no() >>> : " + svo.getDsu_no());
		
		
		ModelAndView mav = new ModelAndView();
		
		// 세션
		HttpSession session = req.getSession(false);
		logger.info("DmySignUpController signUpMatch session >>> : " + session);
		
		if(session != null) {
			dsu_no = String.valueOf(session.getAttribute("dsu_no"));
			svo.setDsu_no(dsu_no);
			logger.info("DmySignUpController mypageListMatch dsu_no >>> : " + dsu_no);
		} else {
			mav.addObject("result", "세션이 만료되었습니다. 다시 로그인 해주세요!");
			return "loginForm";
		} try {
			int nCnt = dmySignUpService.signUpMatch(svo);
			logger.info("DmySignUpController SignUpMatch nCnt >>> : " + nCnt);
			if(nCnt > 0) {
				// 신청 성고시 뷰 페이지
				resultStr = "신청 성공";
				mav.addObject("dmySignUpVO", dmySignUpService.viewSignUp(svo));
				// resultPage = "";
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.getMessage());
			resultStr = "신청에 문제가 발생하여 실패했습니다";
			// resultPage
			// logger.info("DmySignUpController signUpMatch dsu_no >>> : " + svo.getDsu_no());
		}
		mav.addObject("result", result);
		System.out.println("DmySignUpController signUpMatch 함수 끝!!");
		logger.info("DmySignUpController signUpMatch 함수 끝!!");
		return "signUp";
		
	}
	
}








