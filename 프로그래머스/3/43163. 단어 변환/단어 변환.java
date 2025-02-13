import java.util.*;

class Solution {
    static String b;
    static String t;
    static String[] w;
    static int answer = Integer.MAX_VALUE;
    static boolean[] v;
    
    static boolean checkOk(String s1, String s2) {
        
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int diff = 0;
        
        for (int i = 0; i<s1.length(); i++) {
            if(c1[i] != c2[i]) diff++;
            if(diff >= 2) return false;
        }
        
        return true;
    }
    
    static void dfs(String word, int cnt) {
        if(word.equals(t)) {
            answer = Math.min(cnt, answer);
            return;
        }
        
        for (int i = 0; i<w.length; i++) {
            if(v[i]) continue;
            
            String go = w[i];
            if(!checkOk(word, go)) continue;
            
            v[i] = true;
            
        
            dfs(go, cnt+1);
            
            
            v[i] = false;
        }
    }
    
    
    public int solution(String begin, String target, String[] words) {
        b = begin;
        t = target;
        w = words;
        v = new boolean[words.length];
        
        dfs(b, 0);
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}