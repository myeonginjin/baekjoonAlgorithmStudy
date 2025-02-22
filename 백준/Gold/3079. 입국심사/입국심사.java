import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long m = sc.nextLong();
		
		long[] times = new long[n];
		
		for (int i = 0; i<n; i++) {
			times[i] = sc.nextLong();
		}
		
		Arrays.sort(times);
		
		long start = 1;
		long end = (long)times[0] * m;
		
		long mid = start + end / 2;
		
		
		while(start <= end) {
			
			mid = (start + end) / 2;
			
			long cnt = 0;
			
			for (int i = 0; i<n; i++) {
				long t = times[i];
				
				cnt += mid / t;
			}
			
			//System.out.println(mid +" " + cnt);
			
			if(cnt < m) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		System.out.println(start);
	}

}
