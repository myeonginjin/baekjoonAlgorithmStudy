import java.util.*;
import java.io.*;

public class Main {
	static int n,d,c;
	static ArrayList<int[]>[] g;
	static int[] v;
	static int maxLen;
	static int cnt;
	static StringBuilder sb;
	
	static void solveTestCase() {
		PriorityQueue<int[]> a = new PriorityQueue<>( (o1,o2) -> {return Integer.compare(o1[1], o2[1]); });
		//ArrayDeque<Integer> a = new ArrayDeque<>();
		
		a.add(new int[] {c, 0});
		Arrays.fill(v, Integer.MAX_VALUE);
        v[c] = 0;
		
		while(!a.isEmpty()) {
			int[] t = a.poll();
			
			int node = t[0];
			int time = t[1];
			
			if(time  > v[node]) continue;
			
			cnt++;
			maxLen = Math.max(maxLen, time);
			
			for (int i = 0; i<g[node].size(); i++) {
				int[] temp = g[node].get(i);
				int nei = temp[0];
				int ttime = temp[1];
				
				if(ttime + time < v[nei]) {
					v[nei] = ttime + time;
					a.add(new int[] {nei, time + ttime});
				}
			}
		}
		sb.append(cnt+" "+maxLen).append("\n");
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while( t --> 0) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			g = new ArrayList[n+1]; for (int i = 0; i<=n; i++) g[i] = new ArrayList<>();
			
			
			v = new int[n+1];
			cnt = 0;
            maxLen = 0;
			
			for (int i = 0; i<d; i++) {
				str = br.readLine();
				st = new StringTokenizer(str);
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				g[b].add(new int[] {a, s});
			}
			
			solveTestCase();
			
		}
		System.out.println(sb);
	}

}
