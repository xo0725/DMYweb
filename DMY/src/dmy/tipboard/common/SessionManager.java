package dmy.tipboard.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionManager {
	
	private static final String KOS_SESSION_ID = "KID";
	private static SessionManager sm = null;
	
	
	public static synchronized SessionManager getInstance() {
		
		if (sm == null) {
			sm = new SessionManager();
		}
		return sm;
	}

	public void setSession(final HttpServletRequest req, final String userID) {
		
		HttpSession hs = req.getSession();
		try {
			hs.setAttribute(KOS_SESSION_ID, userID);
		}catch(Exception e) {throw e;}	
	}
	
	public String getSession (final HttpServletRequest req) {
		
		HttpSession hs = req.getSession(false);
		String s = "";
		try {
			s = String.valueOf(hs.getAttribute(KOS_SESSION_ID));
		}catch(Exception e) {throw e;}	
	
		return s;
	}
	
	public void killSession(final HttpServletRequest req) {
		
		HttpSession hs = req.getSession(false);
		
		if (hs !=null) {
			hs.removeAttribute(KOS_SESSION_ID);
			hs.invalidate();
		}	
	}
}
