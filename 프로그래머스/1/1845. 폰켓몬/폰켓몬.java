import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashSet<Integer> hs = new HashSet<Integer>();
        
        for (int i = 0; i<nums.length; i++) {
            hs.add(nums[i]);
        }
        
        int size = hs.size();
        
        
        if(size >= nums.length/2) {
            answer = nums.length/2;
        } else {
            answer = size;
        }
        
        return answer;
    }
}