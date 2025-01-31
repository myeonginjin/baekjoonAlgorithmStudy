class Solution {
    public int solution(int[][] triangle) {
        long[][] dp = new long[triangle.length][500];
        dp[0][0] = triangle[0][0];
    
        
        for (int i = 1; i<triangle.length; i++) { //위에서 내려보내기
            
            int[] t = triangle[i]; 
            
            for (int j = 0; j < t.length; j++) {
                long left = Integer.MIN_VALUE;
                long right = Integer.MIN_VALUE;
                
                if(j-1 >= 0) {
                    left = dp[i-1][j-1];
                }
                
                if(j < triangle[i-1].length) {
                    right = dp[i-1][j];
                }
                
                dp[i][j] = Math.max(right, left) + triangle[i][j];
            }
            
        }
        int answer = 0;
        
        // for (long[] t  : dp) {
        //     for (long tt : t) {
        //         System.out.print(tt +" ");
        //     }
        //     System.out.println();
        // }
        
        for (int i = 0; i<triangle.length; i++) {
            if( answer < dp[triangle.length-1][i]) answer = (int) dp[triangle.length-1][i];
        }
        
        return answer;
    }
}