import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int ansIndex = 0;
        
        for (int i = 0; i<commands.length; i++) {
            int[] t = commands[i];
            int str = t[0]-1;
            int las = t[1]-1;
            int index = t[2]-1;
            
            int[] newA = new int[las - str +1];
            int tIndex = 0;
            
            for (int j = str; j<=las; j++){
                
                newA[tIndex++] = array[j];
            }
            Arrays.sort(newA);
            answer[ansIndex++] = newA[index];
        }
        return answer;
    }
}