import java.util.*;
import java.io.*;

public class Main {
	static int n,sum;
	static int[] a;
	static boolean[] v;
	static int minDir = Integer.MAX_VALUE;
	static int ansSum = 0;
	
	static void comb(int index , int str, int curSum) {
		
		if(index == 3) {
			
			if(minDir > Math.abs(curSum-sum) && curSum <= sum) {
				minDir =  Math.abs(curSum-sum);
				ansSum = curSum;
			}
			return;
		}
		
	
		for (int i = str; i<n; i++) {
			if(v[i]) continue;
			v[i] = true;
			
			comb(index+1,str+1, curSum + a[i]);
			
			v[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		n = Integer.parseInt(st.nextToken());
		sum = Integer.parseInt(st.nextToken());
		
		a = new int[n];
		v = new boolean[n];
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		for (int i = 0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(0,0,0);
		
		System.out.println(ansSum);
		br.close();
	}

}
