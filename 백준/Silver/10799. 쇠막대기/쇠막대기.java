import java.util.*;


public class Main {

    public static void main(String[] args) {
        Stack<Character> s= new Stack<>();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        char[] arr = str.toCharArray();

        int ans = 0;

        for (int i = 0; i<arr.length; i++ ) {
            
            char c = arr[i];

            if(c =='(') {
              s.push(c);
            } 
            else {

              if(arr[i-1] == '(') ans += s.size() - 1;

              else ans += 1;
              
              s.pop();
            }
        }

        System.out.println(ans);
    }
}