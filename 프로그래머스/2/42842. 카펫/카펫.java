class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int x = 0;
        int y = 0;
        
        for (int i = 1; i<=yellow; i++) {
                
            for (int j = 1; j<=i; j++) {
                
                if(i*j == yellow) {
                    
                    if( 2 * (i+j) + 4 == brown) {
                        return new int[]{i+2, j+2};
                    }
                    
                }
            }
            
        }
        return answer;
    }
}