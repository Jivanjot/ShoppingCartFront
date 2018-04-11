package com.shopping.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	
	//private static String rootPath = System.getProperty("catalina.home");
	private static String rootPath="E:\\project\\maven\\ShoppingCartFE\\src\\main\\webapp\\resources\\images\\ShoppingCartImages";
	
	
	
	public static boolean copyFile(MultipartFile file, String filename) {
		
		File dest=new File(rootPath+File.separator+filename);
	    
		/*if(!dest.exists()) {
			dest.mkdirs();
		}*/
		
		
		try {
			file.transferTo(dest);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
