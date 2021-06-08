package dmy.tipboard.common;

public abstract class ChabunUtil {


	public static final String BIZ_GUBUN_B 	= "B"; // 게시판 : BOARD
	
	// type : D : 20210001, M : YYYYMM, Y : YYYY, N : 
	public static String numPad(String t, String c){
	
		for (int i=c.length(); i < 4; i++) {
			c = "0" + c;
		}				
		String ymd = DateFormatUtil.ymdFormats(t);
		
		return ymd.concat(c);
	}
	
	
	// 게시판 글 번호  
	public static String getTipBoardChabun(String type, String memNum) {
		
		return BIZ_GUBUN_B.concat(ChabunUtil.numPad(type, memNum));
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String c = "1";
		System.out.println(">>> : " + ChabunUtil.getTipBoardChabun("N", c));
		
	}
}
