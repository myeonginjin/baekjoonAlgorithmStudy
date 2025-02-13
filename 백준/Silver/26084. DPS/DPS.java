import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Character, Integer> team = new HashMap<>();
		char[] handle = new char[256];
		
		char[] cs = br.readLine().toCharArray();
		
		for (int i = 0; i<cs.length; i++) {
			char c = cs[i];
			if(team.containsKey(c)) {
				team.put(c, team.getOrDefault(c, 0) + 1);
			}
			
			else {
				team.put(c, 1);
			}
		}
		
		int num = Integer.parseInt(br.readLine());
		
		for (int i = 0; i<num; i++) {
			char c = br.readLine().charAt(0);
			handle[c]++;
		}
		
		long answer = 1;
		
		// 경우의 수 계산 시작
		out :for (Map.Entry<Character, Integer> em : team.entrySet()) {
			char c = em.getKey();
			int r = em.getValue();
			
			int n = handle[c];

			
            long mul = combin(n, r);

			
			answer *= mul;
		}
		
		System.out.println(answer);
		
	}
	
	
    // 조합 계산 최적화 (팩토리얼 직접 계산 안 함)
    static long combin(int n, int r) {
        long result = 1;
        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }

}
