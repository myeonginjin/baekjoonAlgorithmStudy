class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        int hol = 0;
        int zza = 0;
        
        for (int i = 0; i < num_list.length; i++) {
            int t = num_list[i];
            
            if(i % 2 == 0) {
                zza += t;
            }
            else {
                hol += t;
            }
        }
        
        return zza > hol ? zza : hol;
    }
}