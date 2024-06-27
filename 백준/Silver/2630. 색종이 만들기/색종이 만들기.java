
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] arr;
	static int oneCnt = 0;
	static int zeroCnt = 0;
	
	static boolean check(int r, int r2, int c, int c2) {
		int type = arr[r][c];
		

		for (int i = r; i<r2; i++) {
			for (int j = c; j<c2; j++) {
				if(arr[i][j] != type) {
					return false;
				}
			}
		} 
		
		if(type ==1) oneCnt++;
		else zeroCnt++;
		
		return true;
	}
	
	static void div(int r, int r2, int c, int c2) {
		if(check(r,r2,c,c2)) return;
		
        int midRow = (r + r2) / 2;
        int midCol = (c + c2) / 2;
        
        // 왼쪽 위
        div(r, midRow, c, midCol);
        // 오른쪽 위
        div(r, midRow, midCol, c2);
        // 왼쪽 아래
        div(midRow, r2, c, midCol);
        // 오른쪽 아래
        div(midRow, r2, midCol, c2);
		return;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for (int i = 0; i<n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			for (int j = 0; j<n; j++) {
				arr[i][j]  = Integer.parseInt(st.nextToken());
			}
		}
		
		div(0,n,0,n);
		
		System.out.println(zeroCnt +" " + oneCnt);
	}
}
