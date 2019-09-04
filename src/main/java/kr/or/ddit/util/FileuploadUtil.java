package kr.or.ddit.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileuploadUtil {

	private static final Logger logger = LoggerFactory.getLogger(FileuploadUtil.class);
	/**
	 * Method : getFilename
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param contentDispostion
	 * @return
	 * Method 설명 : Content-disposition 헤더 문자열로 부터 파일이름 추출 
	 */
	public static String getFilename(String contentDispostion) {
		//메소드 인자 : "form-data; name=\"file\"; filename=\"brown.png\"";
		String[] attrs = contentDispostion.split("; ");
		//logger.debug("attr {}", attrs[2]);
		
		String filename = "";
		for(String attr : attrs) {
			if(attr.startsWith("filename")) {
				String[] keyValue = attr.split("=");
				filename = keyValue[1].substring(keyValue[1].indexOf("\"")+1, keyValue[1].lastIndexOf("\""));
				break;
			}
		}
		
		return filename;
	}
	/**
	 * Method : getFileExtension
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param contentDispostion2
	 * @return
	 * Method 설명 : Content-disposition 헤더 문자열로 부터 파일이름 추출
	 */
	public static String getFileExtension(String contentDispostion) {
		
		String filename = getFilename(contentDispostion);
		logger.debug("filename {}", filename);
		
//		if(filename.indexOf(".") == ) {
//			
//		}
		
//		String file = "";
//		if(!filename.contains(".")) {
//			file = ""; 
//		}else {
//			file = filename.substring(filename.indexOf("."), filename.length);
//		}
		
		if(filename.lastIndexOf(".") > 0) {
			logger.debug(filename.substring(filename.lastIndexOf(".")));
			return filename.substring(filename.lastIndexOf("."));
		}else {
			return "";
		}
			
		
		
		
		
	}
	public static String getPath() {
		String basicPath = "d:\\upload";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String yyyyMM = sdf.format(new Date()); //201908
		String yyyy = yyyyMM.substring(0, 4);
		String mm = yyyyMM.substring(4, 6);
		
		File yyyyDirectory = new File(basicPath  + "\\" + yyyy + "\\" + mm);
		if(!yyyyDirectory.exists()) {
			yyyyDirectory.mkdirs();
		}
		
		//d:\\upload\\2019\\08\\
		return basicPath  + "\\" + yyyy + "\\" + mm + "\\";
	}
	
}
