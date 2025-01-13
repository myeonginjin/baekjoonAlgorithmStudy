import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] arr = Arrays.stream(numbers).boxed().map(String::valueOf).toArray(String[]::new);
        
        Arrays.sort(arr, (o1, o2) -> {return -(o1+o2).compareTo(o2+o1);}); 
        
        StringBuilder sb = new StringBuilder();
        int t = 0;
        for (String s : arr){
            sb.append(s);
        }
        
        answer = sb.toString();
        
        if(answer.substring(0,1).equals("0")) return "0";
           
        return answer;
        
    }
}