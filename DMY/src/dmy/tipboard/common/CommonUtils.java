package dmy.tipboard.common;

public abstract class CommonUtils {
	
	// 이미지 업로드 	

	public static final String IMG_UPLOAD_PATH = "C:\\00.KOSMO78\\100.Project\\DMYweb\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\DMY\\imgupload";
	//public static final String IMG_UPLOAD_PATH = "C:\\00.KOSMO72\\eclipseSpringWork\\testSpring3\\WebContent\\imgupload";
	public static final int IMG_FILE_SIZE = 2*1024*1024; // 2MB
	public static final String EN_CODE = "EUC-KR";
	
	// 파일 업로드 
	public static final String FILE_UPLOAD_PATH = "C:\\00.KOSMO78\\100.Project\\DMYweb\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\DMY\\fileupload";
	public static final int FILE_FILE_SIZE = 10*1024*1024; // 10MB
	
	// 게시판 페이징 사이즈 초기화 
	public static final String B_PAGE_SIZE = "3";
	public static final String B_GROUP_SIZE = "2";
	public static final String B_CUR_PAGE = "1";
	public static final String B_TOTAL_COUNT = "";

}
