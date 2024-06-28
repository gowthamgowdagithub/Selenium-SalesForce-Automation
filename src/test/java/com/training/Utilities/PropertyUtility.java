package com.training.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {

	public static String readDataFromTheFile(String path, String key) {
		File spath=new File(path);
		FileInputStream fio=null;
		Properties propFile=new Properties();
		String data=null;
		
		try {
			fio=new FileInputStream(spath);
			propFile.load(fio);
			data=propFile.getProperty(key);
			fio.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("-------There is some error in the file path-----");
			e.printStackTrace();
		}
		catch(IOException e) {
			System.out.println("----Error while loading file property-----");
			e.printStackTrace();
		}
		return data;
	}
	
}
