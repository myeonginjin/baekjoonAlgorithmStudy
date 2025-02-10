import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        ArrayList<Integer> a = new ArrayList<>();
        
        for (int i = 0; i<operations.length; i++) {
            String[] process = operations[i].split(" ");
            
            String type = process[0];
            int num = Integer.parseInt(process[1]);
            
            if(type.equals("I")){
                a.add(num);
            } else if (type.equals("D") && num == -1) {
                
                if(a.isEmpty()) continue;
                
                Collections.sort(a , (o1, o2) -> {
                   return Integer.compare( o1, o2 ) ;
                });
                a.remove(0);
            } else {
                
                if(a.isEmpty()) continue;
                
                Collections.sort(a , (o1, o2) -> {
                   return -Integer.compare( o1, o2 ) ;
                });
                a.remove(0); 
            }
            // for (int t  : a) {
            //     System.out.print(t+" ");
            // }System.out.println();
        }
        
        
        
        int[] answer = new int[2];
        
        if(a.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
            }
        else {
            Collections.sort(a , (o1, o2) -> {
                   return -Integer.compare( o1, o2 ) ;
                });
            
            if(a.size() >= 2) {
                answer[0] = a.get(0);
                answer[1] = a.get(a.size()-1);
            } else {
                answer[0] = a.get(0);
                answer[1] = a.get(0);
            }
        }
        

        
        return answer;
    } 
}