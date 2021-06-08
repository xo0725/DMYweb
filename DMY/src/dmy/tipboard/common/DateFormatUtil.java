package dmy.tipboard.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateFormatUtil {

	public static String ymdFormat(){
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
	}
	
	public static String ymFormat(){
		return new SimpleDateFormat("yyyyMM").format(new Date());
	}
	
	public static String yFormat(){
		return new SimpleDateFormat("yyyy").format(new Date());
	}
	
	public static String ymdFormats(String ymdFlag){
		
		String sd = "";		
		Date d = new Date();
		
		if ("D".equals(ymdFlag.toUpperCase())){
			sd = new SimpleDateFormat("yyyyMMdd").format(d);
		}
		if ("M".equals(ymdFlag.toUpperCase())){
			sd = new SimpleDateFormat("yyyyMM").format(d);
		}
		if ("Y".equals(ymdFlag.toUpperCase())){
			sd = new SimpleDateFormat("yyyy").format(d);
		}
		if ("N".equals(ymdFlag.toUpperCase())){
			sd = "";
		}
		
		return sd;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
