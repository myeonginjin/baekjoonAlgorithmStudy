import java.util.*;

class Solution {
    static String[][] a;
    static boolean[] v;
    static String[] b;
    static int cnt;
    HashMap<String, Integer> hm = new HashMap<>();
    
    public int solution(String[][] clothes) {
        
        for (int i = 0; i< clothes.length; i++) {
            String category = clothes[i][1];
                
            if(hm.containsKey(category)) {
                hm.replace(category , hm.get(category) + 1);
            } else {
                hm.put(category, 1);
            }
        }
        
        int ans = 1;
        for (Map.Entry<String, Integer> en : hm.entrySet()) {
            ans *= en.getValue() + 1 ;
        }
        
        return ans-1;
    }
    
    
}