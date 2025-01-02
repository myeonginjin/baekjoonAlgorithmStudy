import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String ans;
        StringBuilder answer = new StringBuilder();
        
        int[] v = new int[10];
        int[] v2 = new int[10];
        
        for (int i = 0; i<X.length(); i++){
            int n = Integer.parseInt(X.substring(i,i+1));
            v[n]++;
        }
        for (int i = 0; i<Y.length(); i++){
            int n = Integer.parseInt(Y.substring(i,i+1));
            v2[n]++;
        }
        
        boolean isZero = true;
        
        for (int i = 9; i>=0; i--) {
            if(v[i]==0 || v2[i]==0) continue;
            
            int duplicate = Math.min(v[i], v2[i]);
            
            if(i!=0) isZero = false;
            
            while(duplicate -->0) answer.append(String.valueOf(i));
        }
        
        ans = answer.toString();
        
        if(ans.length()==0) return "-1";
        if(isZero) return "0";
        
        
        return ans;
    }
}