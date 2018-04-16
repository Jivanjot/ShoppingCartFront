package com.shopping.util;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	// private static String rootPath = System.getProperty("catalina.home");
	private static String rootPath = "E:\\project\\maven\\ShoppingCartFE\\src\\main\\webapp\\resources\\images\\ShoppingCartImages";

	public static boolean copyFile(MultipartFile file, String filename) {

		File dest = new File(rootPath + File.separator + filename);

	
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
