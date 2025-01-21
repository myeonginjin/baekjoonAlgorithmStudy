import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();

        
        for (int i = 0; i<citations.length; i++) {
            int n = citations[i];
            
            if(!hm.containsKey(n)) hm.put(n , 1);
            
            else {
                int cnt = hm.get(n);
                        
                hm.replace(n , cnt + 1);        
            }

            
            for (int j = n-1; j>=0; j--) {
                if(!hm.containsKey(j)) hm.put(j , 1);

                else {

                    int cnt = hm.get(j);

                    hm.replace(j , cnt + 1);

                }
            }
            
        }
        
        PriorityQueue<int[]> q = new PriorityQueue<>(
            (o1,o2) -> { return -Integer.compare(o1[0], o2[0]); }
        );
        
        for (Map.Entry<Integer, Integer> em : hm.entrySet() ) {
            q.add(new int[] { em.getKey(), em.getValue() } );
        }
        

        while(!q.isEmpty()) {
            int[] t = q.poll();
            
            int c = t[0];
            int cnt = t[1];
            
            if(cnt >= c && !q.isEmpty()) {
                
                int under = q.peek()[1];
                
                if(cnt >= under) return c;
                
            }
        }
        
        
        int answer = 0;
        return answer;
    }
}