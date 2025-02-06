package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class InputClass {

	static final Scanner scn = new Scanner(System.in);

	public static int[] getIntArrayFromString(String input) {
		return Arrays.asList(input.split(",")).stream().map(Integer::parseInt).mapToInt(Integer::intValue).toArray();
	}

}
