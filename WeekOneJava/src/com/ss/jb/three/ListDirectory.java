/**
 * 
 */
package com.ss.jb.three;

import java.io.File;

/**
 * @author Luis Fernandez
 *
 */
public class ListDirectory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String currDirectoryPath = System.getProperty("user.dir");
	    File currDir = new File(currDirectoryPath);
	    
	    File[] files = currDir.listFiles();
	    
	    for(File file: files) {
	    	if (file.isDirectory()) {
	    		System.out.println("-" + file.getName());
	    		File[] subFiles = file.listFiles();
	    		for(File subFile: subFiles) {
	    			System.out.println("  -" + subFile.getName());
	    		}
	    	}
	    	else {
	    		System.out.println("-" + file.getName());
	    	}
	    	
	    }
	}

}
