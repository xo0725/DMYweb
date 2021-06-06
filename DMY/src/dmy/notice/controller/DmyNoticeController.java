package dmy.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dmy.notice.service.DmyNoticeService;

@Controller
public class DmyNoticeController {
	
	//@Autowired
	//private DmyNoticeService dmyNoticeService;
	
	@RequestMapping("noticeListAll")
	public String noticeListAll() {
		
		System.out.println("noticeListAll ¡¯¿‘");
		
		return "notice/dmyNoticeListAll";
	}
	
}
