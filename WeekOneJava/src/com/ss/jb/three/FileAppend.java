/**
 * 
 */
package com.ss.jb.three;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author Luis Fernandez
 *
 */
public class FileAppend {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("resources/in/in.txt");
			out = new FileOutputStream("resources/out/out.txt",true); // append flag set to true.
			
			int c;
			while((c = in.read()) != -1) {
				out.write(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
