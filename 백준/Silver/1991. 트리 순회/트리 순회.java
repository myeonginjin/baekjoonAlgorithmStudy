import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static StringBuilder sb = new StringBuilder();
	static char[] tree;
	static char maxChar;
	
	static void preOrder(int index) {
		int n = tree[index];
		
		if( 'A' <= n && n <= 'Z') sb.append(tree[index]);
		if(n > maxChar) return;
			
		preOrder(index*2);
		preOrder(index*2+1);
	}
	
	static void inOrder(int index) {
		int n = tree[index];
		if(n > maxChar) return;
		
		inOrder(index*2);
		
		if( 'A' <= n && n <= 'Z') sb.append(tree[index]);
		
			
		inOrder(index*2+1);
	}
	
	static void postOrder(int index) {
		int n = tree[index];
		if(n > maxChar) return;
		
		postOrder(index*2);
		postOrder(index*2+1);
		
		if( 'A' <= n && n <= 'Z') sb.append(tree[index]);
			
	}
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/study/input_1991"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String str;
		StringTokenizer st;
		
		maxChar =  (char)('A'+n-1);
		tree = new char[100000000];
		tree[1] = 'A';
		int[] index = new int[256];
		index['A'] = 1;

		
		for (int i = 0; i<n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			
			
			int rootIndex = index[root];
			left = left == '.' ? 'x' : left;
			right = right == '.' ? 'x' : right;
			
			//System.out.println(root +" "+ rootIndex);
			
			tree[rootIndex * 2] = left;
			tree[rootIndex * 2+1] = right;
			
			if(left != 'x') index[left] = rootIndex * 2;
			if(right != 'x' ) index[right] = rootIndex * 2 + 1;
		}
		
		//System.out.println(Arrays.toString(tree));
		
		preOrder(1);
		sb.append("\n");
		inOrder(1);
		sb.append("\n");
		postOrder(1);
		
		
		System.out.println(sb);
	}
}
