import java.util.*;

class Solution {
    static String[] a;
    static String[] b;
    static boolean[] v;
    static int len;
    static String num;
    static int answer;
    static HashSet<String> hs = new HashSet<>();
    
    public int solution(String numbers) {

        num = numbers;
        
        len = numbers.length();
        
        a = new String[len];
        b = new String[len];
        v = new boolean[len];
        
        for (int i = 0; i<len; i++) {
            a[i] = numbers.substring(i,i+1);
        }
        
        dfs(0, "");
        
        count();
        
        return answer;
    }
    
    static void count() {
        
        for (String s : hs) {
            if(s.substring(0,1).equals("0")) continue;
            
            int num = Integer.parseInt(s);
            int cnt = 0;
            
            for (int i = 1; i<=num; i++) {
                if(cnt > 2) break;
                
                if(num % i == 0) cnt++;
            }
            if(cnt==2) answer++;
        }
        
    }
    
    
    static void dfs(int cnt, String s) {
        if(cnt >= len) {
            return;
        }
        
        for (int i = 0; i<len; i++) {
            if(v[i]) continue;
            
            v[i] = true;
            
            if(hs.add(s + num.charAt(i)));
            
            dfs(cnt+1, s + num.charAt(i));
            
            v[i] = false;
        }
    }
}