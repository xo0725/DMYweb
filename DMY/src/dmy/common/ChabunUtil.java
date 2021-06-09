package dmy.common;

public abstract class ChabunUtil {

	public static final String BIZ_GUBUN_SM = "SM"; // 매칭 신청
	
	// type : D : 20210001, M : YYYYMM, Y : YYYY, N
	
	public static String numPad(String t, String c) {

		for (int i = c.length(); i < 4; i++) {
			c = "0" + c;
		}
		String ymd = DateFormatUtil.ymdFormats(t);
		return ymd.concat(c);
	}

	// 매칭 신청 번호
	public static String getSignUpChabun(String type, String memNum) {
		
		return BIZ_GUBUN_SM.concat(ChabunUtil.numPad(type, memNum));
	}
	
	public static void main(String[] args) {
		 String c = "1";
		 System.out.println(">>> : " + ChabunUtil.getSignUpChabun("N", c));
	}
	
}
