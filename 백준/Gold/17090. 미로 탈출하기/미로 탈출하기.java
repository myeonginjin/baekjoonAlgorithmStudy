import java.util.*;
import java.io.*;

public class Main {
	static int n,m;
	static char[][] a;
	static boolean[][] can;
	static boolean[][] cant;
	static boolean[][] v;
	static int answer;
	
	static boolean canGo(int r, int c) {
		return r >= 0 && r<n && c >= 0 && c < m;
	}
	
	static boolean dfs(int r, int c) {
		
		if(canGo(r,c) && cant[r][c]) return false;
		
		if(!canGo(r,c) || can[r][c]) {
			return true;
		}
		
		if(v[r][c]) return false; //싸이클 발생 방지 
		v[r][c] = true;

		
		char type = a[r][c];
		
		int nr = 0; 
		int nc = 0;
		
		switch(type) {
		
		case 'U':
			nr = r-1;
			nc = c;

			if(dfs(nr, nc)) {
				can[r][c] = true;
				v[r][c] = false;
				return true;
			}
			//v[r][c] = false;
			
			break;
		case 'R':
			nr = r;
			nc = c + 1;

			if(dfs(nr, nc)) {
				can[r][c] = true;
				v[r][c] = false;
				return true;
			}
			//v[r][c] = false;
			
			break;
		case 'D':
			nr = r + 1;
			nc = c;
			
			if(dfs(nr, nc)) {
				can[r][c] = true;
				v[r][c] = false;
				return true;
			}
			//v[r][c] = false;
			
			break;
		case 'L':
			nr = r;
			nc = c -1;

			if(dfs(nr, nc)) {
				can[r][c] = true;
				v[r][c] = false;
				return true;
			}
			//v[r][c] = false;
			
			break;
		}
		
		cant[r][c] = true;
		
		return false;
			 
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		a = new char[n][m];
		can = new boolean[n][m];
		cant = new boolean[n][m];
		v = new boolean[n][m];
		
		for (int i = 0; i<n; i++) {
			str = br.readLine();
			char[] t = str.toCharArray();
			a[i] = t;
		}
		
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<m; j++) {
				if(can[i][j]) {
					answer++;
					continue;
				}
				if(cant[i][j]) continue;
				
				if(dfs(i, j)) {
					answer++;
					can[i][j] = true;
				} else {
					cant[i][j] = true;
				}
			}
		}
		
		System.out.println(answer);
	}
}
