class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int xMax = Integer.MIN_VALUE;
        int yMax = Integer.MIN_VALUE;
        
        for (int i = 0; i<sizes.length; i++){
            int[] t = sizes[i];
            
            int tXMax = Math.max(t[0], t[1]);
            int tYMax = Math.min(t[0], t[1]);
            
            if (xMax < tXMax) {
                xMax = tXMax;
                
                if (yMax <  tYMax)
                    yMax = tYMax;
            } 
            
            else if (yMax < tYMax) yMax = tYMax;
        }
        
        answer = xMax * yMax;
            
        return answer;
    }
}