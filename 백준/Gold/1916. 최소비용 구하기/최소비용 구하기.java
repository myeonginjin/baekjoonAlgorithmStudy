

import java.util.*;
import java.io.*;

public class Main {
	static int n,m,s,t;
	static ArrayList<int[]>[] g;
	static int[] weight;
	
	static void bfs() {
		PriorityQueue<int[]> q = new PriorityQueue<>( (o1, o2) -> {
			return Integer.compare(o1[1], o2[1]);
		} );
		
		q.add(new int[] {s,0});
		for (int i = 0; i<=n; i++) weight[i] = Integer.MAX_VALUE;
		weight[s] = 0;
		
		while(!q.isEmpty()) {
			int[] t = q.poll();
			
			int node = t[0];
			int w = t[1];
			
			if(weight[node] < w) continue;
			
			
			for (int i = 0; i<g[node].size(); i++) {
				int[] temp = g[node].get(i);
				
				int nei = temp[0];				
				int wei = temp[1];
				
				if( w + wei < weight[nei]) {
					weight[nei] = w + wei;
					q.add(new int[] {nei, w + wei});
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		g = new ArrayList[n+1]; for (int i = 0; i<=n; i++) g[i] = new ArrayList<>();
		weight = new int[n+1];
		
		String str;
		StringTokenizer st;
		
		for (int i = 0; i<m; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			int go = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			g[go].add(new int[]{to, w});
		}
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		s = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		bfs();
		//System.out.println(Arrays.toString(weight));
		System.out.println(weight[t]);
	}

}
