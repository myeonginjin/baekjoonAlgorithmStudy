import java.util.*;

public class Main {
	static int go, to;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		int go = Math.min(n1, n2);
		int to = Math.max(n1, n2);
		
		long[][] dp = new long[31][31];
		
		dp[go][go] = 1;
		
		for (int i = go + 1; i<31; i++) {
			for (int j = go; j<31; j++) {
				if(i < j) continue;
				
				long down = i > 0 ? dp[i-1][j] : 0;
				long left = j > 0 ?  dp[i][j-1] : 0;
				
				dp[i][j] = down +left;
				
				//System.out.println(dp[i-1][j] +" " + dp[i][j-1]);
			}
		}
		
		System.out.println(dp[to][to]); 
		
//		for (int[] t : dp) {
//			System.out.println(Arrays.toString(t));
//		}
		
		
	}
}
