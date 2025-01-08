import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int cnt = 0;
        
        int[] a = new int[n+1]; 
        for (int i = 1; i<=n; i++) a[i] = 1;
        
        for (int i = 0; i<reserve.length; i++) {
            int rest = reserve[i];
            a[rest]++;
        }
        
        for (int i = 0; i<lost.length; i++) {
            int los = lost[i];
            a[los]--;
        }
        
        for (int i = 1; i<=n; i++) {
            int num = a[i];
            
            if(num >= 1){
                cnt++;
            } else {
                
                if(i>1 && a[i-1] > 1) {
                    cnt++;
                } else if (i < n && a[i+1] > 1) {
                    cnt++;
                    a[i+1]--;
                }
            }
        }
    
        return cnt;
    }
}