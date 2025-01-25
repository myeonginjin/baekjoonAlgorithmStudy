import java.util.*;

class Solution {
    static HashMap<String, Integer> hm = new HashMap<>();
    static char[] a;
    static boolean[] v;
    static int n;
    static int cnt = -1;
    static String target;
    static boolean find;
    static int answer;
    
    static void com(int index, String str) {
        
        if(find) return;
        
        cnt++;
        
        if(target.equals(str)) {
            answer = cnt;
            find = true;
            return;
        }
        
        hm.put(str , cnt);
        
        if(index == n) {            
            return;
        }
        
        for (int i = 0; i<n; i++) {
            com( index + 1 , str + a[i]);
        }
    }
    
    public int solution(String word) {
        n = 5;
        
        target = word;
        
        a = new char[]{'A', 'E', 'I', 'O', 'U'};
        
        com(0 , "");
        
        //int answer = 0;
        
        //answer = hm.get(word);
        
//         for (Map.Entry<String, Integer> em : hm.entrySet()) {

//             System.out.println(em.getKey() +"  "+em.getValue());    
//         }
        
        
        
        return answer;
    }
    
}