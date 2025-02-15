

import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static ArrayList<Integer>[] g;
	static int n1, n2;
	static boolean[] v;
	static int answer = -1;
	
	static void dfs(int node, int t, int cnt) {
		for (int i = 0; i<g[node].size(); i++) {
			int c = g[node].get(i);
			if(v[c]) continue;
			
			if(c == t) {
				answer = cnt;
				return;
			}
			
			else {
				v[c] = true;
				dfs(c, t, cnt+1);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		g = new ArrayList[n+1]; for (int i = 0; i<=n; i++) g[i] = new ArrayList<>();
		v = new boolean[n+1];
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		n1 = Integer.parseInt(st.nextToken());
		n2 = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i<m; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			g[p].add(c);
			g[c].add(p);
		}
		
		dfs(n1, n2, 1);

			
		System.out.println(answer);
	}

}
