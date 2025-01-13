import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        Arrays.sort(people);
        
        int i = 0;
        int j = people.length - 1;
        
        int answer = 0;
        
        while(i <= j) {
            if(i==j) {
                answer++;
                break;
            }
            
            int large = people[j];
            
            if(large + 40 > limit) {
                answer++;
                j--;
            }
            
            if(people[i] + large <= limit) {
                i++;
            }
            
            answer++;
            j--;
            
        }
        
        
        return answer;
    }
}


