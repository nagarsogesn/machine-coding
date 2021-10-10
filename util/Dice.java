/**
 * @author Shivshankar
 * on 10-Oct-2021
 */
package com.machinecode.snakeladder.util;

import java.util.Random;

public class Dice {

	public static int roll() {
		Random random = new Random();
		return random.nextInt(6) + 1;
	}

}
