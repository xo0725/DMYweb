package dmy.tipboard.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dmy.tipboard.common.CommonUtils;

public abstract class FileReadUtil {
	
	private static String FILE_PATH = CommonUtils.IMG_UPLOAD_PATH;
	
	public static void readFile(HttpServletRequest req,
			                    HttpServletResponse res) throws IOException {
		
		req.setCharacterEncoding("EUC-KR");
		//String fileName = String.valueOf(req.getAttribute("filename"));
		String fileName = "ase.gif";
		String filePath = FILE_PATH.concat("\\").concat(fileName);
		File f = new File(filePath);
		
		System.out.println("fileName >>> : " + fileName);
		System.out.println("filePath >>> : " + filePath);
		System.out.println("f >>> : " + f);
		
		if (f.isDirectory()) {
			return;
		}
		
		long fileSize = f.length();
		if (fileSize > Integer.MAX_VALUE) {
			System.out.println("파일 사이즈가 너무 크네요 >>> : ");
			return;
		}
		
		// MIME TYPE
		String mimeType;
		String disposition = "filename=\"" + filePath + "\"";
		
		if(filePath.toLowerCase().endsWith("xml")){
			mimeType = "text/xml;charset=euc-kr";
		}else if(filePath.toLowerCase().endsWith("doc")){
			mimeType = "application/msword";
		}else if(filePath.toLowerCase().endsWith("xls")){
			mimeType = "application/vnd.ms-excel";
		}else if(filePath.toLowerCase().endsWith("xlsx")){
			mimeType = "application/x-msexcel";
		}else if(filePath.toLowerCase().endsWith("hwp")){
			mimeType = "application/octet-stream";
		}else if(filePath.toLowerCase().endsWith("gif")){
			mimeType = "image/gif";
		}else if(filePath.toLowerCase().endsWith("jpg")){			
			mimeType = "image/jpeg";
		}else{
			mimeType = "application/octet-stream";
		}
		// response set
		res.setBufferSize(0);
		
		fileName = new String(fileName.getBytes("EUC-KR"), "ISO-8859-1");
		res.setHeader("Content-Disposition", "attachment; filename=" + fileName + ";");
		res.setHeader("Content-Transfer-Encoding", "7bit");
		res.setHeader("Accept-Ranges", "bytes");
		res.setContentLength((int)fileSize);
		res.setHeader("Connection", "close");
		res.setContentType(mimeType + ";charset=euc-kr");

		FileInputStream in = new FileInputStream(f);
		
		final int BUF_SIZE = 8 * 1024;
		final OutputStream out = res.getOutputStream();
		final byte[] buf = new byte[BUF_SIZE];
		int n;
		
		while(-1 != (n = in.read(buf)))
		{
			out.write(buf, 0, n);
		}
		out.flush();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
