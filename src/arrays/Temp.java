package arrays;

public class Temp {

	public static void main(String[] args) {
		
		int a = 2, b = 5;
		System.out.println(getPower(a, b));
		
	}
	
	public static long getPower(int a, int b) {
		
		long ans = 1;
		while (b != 0) {
			if ((b & 1) == 1) {
				ans *= a;
			}
			a *= a;
			b /= 2;
		}
		return ans;
		
	}
	
}
