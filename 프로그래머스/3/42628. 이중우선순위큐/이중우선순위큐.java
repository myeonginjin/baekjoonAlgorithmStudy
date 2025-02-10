import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        ArrayList<Integer> a = new ArrayList<>();
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        PriorityQueue<Integer> rQ = new PriorityQueue<>(
            (o1, o2) -> { return -Integer.compare(o1, o2); }
        );
        
        for (int i = 0; i<operations.length; i++) {
            String[] process = operations[i].split(" ");
            
            String type = process[0];
            int num = Integer.parseInt(process[1]);
            
            if(type.equals("I")){
                //a.add(num);
                q.add(num);
                rQ.add(num);
            } else if (type.equals("D") && num == -1) {
                
                if(q.isEmpty()) continue;
                
                // Collections.sort(a , (o1, o2) -> {
                //    return Integer.compare( o1, o2 ) ;
                // });
                // a.remove(0);
                int min = q.poll();
                rQ.remove(min);
                
            } else {
                
                if(q.isEmpty()) continue;
                
                // Collections.sort(a , (o1, o2) -> {
                //    return -Integer.compare( o1, o2 ) ;
                // });
                // a.remove(0); 
                
                int max = rQ.poll();
                q.remove(max);
            }

        }
        
        
        
        int[] answer = new int[2];
        
        if(q.isEmpty() && rQ.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
            }
        else {
            // Collections.sort(a , (o1, o2) -> {
            //        return -Integer.compare( o1, o2 ) ;
            //     });

            
            if(q.isEmpty()) {
                int n = rQ.poll();
                answer[0] = n;
                answer[1] = n;
            } 
            
            if(rQ.isEmpty()) {
                int n = q.poll();
                answer[0] = n;
                answer[1] = n;               
            }
            
            else {
                answer[0] = rQ.poll();
                answer[1] = q.poll();
            }
            
            
        }
        

        
        return answer;
    } 
}