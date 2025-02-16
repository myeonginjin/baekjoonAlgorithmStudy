import java.util.*;

public class Main {
	static int n,s;
	static int[] a;
	static ArrayList<Integer> b;
	static int cnt;
	
	static void sub(int index) {
		if(index == n) {
            if(b.size()== 0) return;
            
			int sum = 0;
			for (int t : b) sum += t;
			
			if(sum == s) {
				cnt++;
			}
			return;
		}
		
		b.add(a[index]); 
		sub(index+1);
		
		b.remove(b.size()-1);
		sub(index+1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		b = new ArrayList<>();
		n = sc.nextInt();
		s = sc.nextInt();
		a = new int[n];
		
		for (int i = 0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		sub(0);
		
		System.out.println(cnt);
	}

}
