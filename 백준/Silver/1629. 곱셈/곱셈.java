import java.util.*;
import java.io.*;

public class Main{
	
	static long recur (int a, int b, int c) {
		if(b <= 1) {
			return a % c;
		}
		
		long half = recur(a, b / 2, c);
		half = (half * half) % c;
		
		// If b is odd, multiply by a once more
		if(b % 2 == 1) {
			half = (half * a) % c;
		}
		
		return half;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		


		System.out.println(recur(a,b,c));

	}

}