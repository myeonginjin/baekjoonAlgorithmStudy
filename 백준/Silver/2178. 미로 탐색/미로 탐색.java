
import java.util.*;
import java.io.*;

public class Main {
	static int n,m;
	static int[][] arr;
	static boolean[][] v;
	static ArrayDeque<int[]> d = new ArrayDeque<>();
	static int minDis = Integer.MAX_VALUE;
	static int[][] dis;
	
	
	static boolean indexOk(int r , int c) {
		return r>=0 && r <n && c >= 0 && c<m;
	}
	
	static void bfs() {
		int[] dx = new int[] {-1,1,0,0};
		int[] dy = new int[] {0,0,-1,1};
		
		while(!d.isEmpty()) {
			int[] t = d.pollLast();
			
			for (int i = 0; i<4; i++) {
				int nextR = t[0] + dx[i];
				int nextC = t[1] + dy[i];
				
				if(indexOk(nextR,nextC) && !v[nextR][nextC] && arr[nextR][nextC] != 0) {
					v[nextR][nextC] = true;
					int distance = dis[t[0]][t[1]] + 1;
					
					if (dis[nextR][nextC] == 1) {
						dis[nextR][nextC] = distance;
					} else {
						dis[nextR][nextC] = Math.min(distance, dis[nextR][nextC]);
					}
					
					d.addFirst(new int[] {nextR, nextC});
				}
			}
			
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("res/input_2178"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		dis = new int[n][m];
		v = new boolean[n][m];
		
		for (int i = 0; i<n; i++) {
			str = br.readLine();
			for (int j = 0; j<m; j++) {
				int temp = Integer.parseInt(str.substring(j,j+1));
				arr[i][j] = temp;
				dis[i][j] = temp;
			}
 		}
		d.addFirst(new int[] {0,0});
		v[0][0] = true;
		bfs();
		
		//for (int[]t:arr) System.out.println(Arrays.toString(t));
		System.out.println(dis[n-1][m-1]);

	}
}
