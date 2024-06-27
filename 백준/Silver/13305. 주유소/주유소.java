
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str;
		StringTokenizer st;
		
		str = br.readLine();
		st = new StringTokenizer(str);
		Long[] distance = new Long[n-1];
		
		for (int i = 0; i<n-1; i++) {
			distance[i] = Long.parseLong(st.nextToken());
		}
		
		str = br.readLine();
		st = new StringTokenizer(str);
		Long[] price = new Long[n];
		for(int i= 0; i<n; i++) {
			price[i] = Long.parseLong(st.nextToken());
		}
		
//		System.out.println(Arrays.toString(distance));
//		System.out.println(Arrays.toString(price));
		
		Long minPrice = 1000000000L;
		Long sum = 0L;
		
		for (int i = 0; i<n-1; i++) {
			if(minPrice > price[i]) {
				minPrice = price[i];
			}
			sum += minPrice*distance[i];
		}
		
		System.out.println(sum);
	}
}
