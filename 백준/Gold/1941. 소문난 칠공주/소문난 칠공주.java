import java.util.*;
import java.io.*;

public class Main {
	static char[][] c = new char[5][5];
	static ArrayList<int[]> a = new ArrayList<>();
	static int[][] b = new int[7][2];
	static int answer;
	
	static void check7() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		boolean[] v = new boolean[7];
		
		int linkedNodeCnt = 1;
		
		
		
		int sCnt = c[b[0][0]][b[0][1]] ==  'S' ? 1 : 0; 
		
		//if (c[b[0][0]][b[0][1]] == 'S') System.out.println( c[b[0][0]][b[0][1]]);
		
		v[0] = true;
		q.add(new int[] {b[0][0], b[0][1]});
		
		while(!q.isEmpty()) {
			int[] t = q.poll();
			
			for (int i = 0; i<7; i++) {
				if(v[i]) continue;
				
				int[] nei = b[i];
				
				if( Math.abs(t[0]-nei[0]) + Math.abs(t[1]-nei[1]) == 1) { // 이웃
					v[i] = true;
					q.add(new int[] {nei[0], nei[1]});
					
					if( c[nei[0]][nei[1]]  == 'S'  ) sCnt++;
					linkedNodeCnt++;
				}
			}
		}
		
		//if(sCnt > 0) System.out.println(linkedNodeCnt +" " + sCnt);
		
		if(linkedNodeCnt == 7 && sCnt >= 4) answer++;
		
	}
	
	
	static void comb(int index, int str) {
		if(index == 7) {
//			for (int[] t  : b) System.out.print(t[0] +" "+t[1] +"  ||  ");
//			System.out.println();
			check7();
			return;
		}
		
		
		for (int i = str; i<25; i++) {
			int[] t = a.get(i);
			
			b[index][0] = t[0];
			b[index][1] = t[1];
			
			comb(index+1, i+1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		
		for (int i = 0; i<5; i++) {
			str = br.readLine();
			char[] t = str.toCharArray();
			
			for (int j = 0; j<5; j++) {
				c[i][j] = t[j];
				a.add(new int[] {i,j});
			}
		}
		
//		for (char[]t : c) {
//			System.out.print(Arrays.toString(t));
//		}System.out.println();
		
		comb(0, 0);
		System.out.println(answer);
	}
}
