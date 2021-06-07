package dmy.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DmyNoticeController {
	
	@RequestMapping("noticeListAll")
	public String noticeListAll() {
		
		System.out.println("noticeListAll ¡¯¿‘");
		
		return "notice/dmyNoticeListAll";
	}
	
}
