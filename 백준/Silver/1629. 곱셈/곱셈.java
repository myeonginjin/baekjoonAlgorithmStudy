import java.util.*;
import java.io.*;

public class Main{
	
	static long recur (long a, long b, long c) {
		if(b <= 1) {
			//if(b==2) return (long)(Math.pow(a%c, 2)) % c;
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
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		

		if (b == 0) {
			System.out.println(1%c);
		} else {
			System.out.println(recur(a,b,c));
		}
		
		
		
	}

}