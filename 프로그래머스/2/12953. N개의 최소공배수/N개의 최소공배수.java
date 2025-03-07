import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        Arrays.sort(arr);
        
        out : for (int i = arr[arr.length-1]; i<=Integer.MAX_VALUE; i++) {
            
            for (int j = 0; j<arr.length; j++) {
                if( i % arr[j] != 0) {
                    //System.out.println(i);
                    continue out;
                }
            }
            return i;
        }
        return answer;
    }
}