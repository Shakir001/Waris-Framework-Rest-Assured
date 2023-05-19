package genericLibrary;

import java.util.Random;

public class JavaLibrary {

	/**
	 * This method is to generate the random number
	 * 
	 * @return
	 */

	public int getRandom() {

		Random ran = new Random();
		int r = ran.nextInt(1000);

		return r;
	}
}
