import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = Integer.MAX_VALUE;
        

            
        int sum = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        

        
        for (int i = 0; i<A.length; i++){
            int n = A[i] * B[B.length -1 -i];
            sum += n;
        }
        
        

        return sum;
    }
}