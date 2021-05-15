/**
 * 
 */
package com.ss.jb.three;

import java.io.FileInputStream;
import java.util.HashMap;

/**
 * @author Luis Fernandez
 *
 */
public class CharacterFrequencyCounter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		HashMap<Character, Integer> charFreq = new HashMap<Character, Integer>();
		FileInputStream in = null;
		int ch;

		// Check for args
		// command line arg should be one character.
		if (args.length > 0 && args[0].length() == 1) {
			try {
				in = new FileInputStream("resources/in/doi.txt");
				// read a character at a time.
				while ((ch = in.read()) != -1) {
					// Check if key has a value.
					// is so. Then, increment value
					Integer value = charFreq.get((char) ch);
					if (value != null) {
						charFreq.put((char) ch, value + 1);
					}
					// Otherwise initialize value to 1.
					else {
						charFreq.put((char) ch, 1);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// Display user specified Frequency.
			Character keyArg = args[0].charAt(0);
			Integer keyArgVal = charFreq.get(keyArg);
			if(keyArgVal != null) {
				System.out.println(keyArg + ": " + charFreq.get(keyArg));
			}
			else {
				System.out.println("Character not found in Text.");
				System.out.println(keyArg + ": 0");
			}
		}
		else {
			System.err.println("Command line arguements missing.");
		}
		System.exit(0);

	}

}
