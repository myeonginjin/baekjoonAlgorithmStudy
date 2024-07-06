import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            if(n1==0 && n2 == 0 && n3==0) break;
            
            // 가장 큰 변 찾기
            int max = Math.max(n1, Math.max(n2, n3));
            int min, mid;
            
            if (max == n1) {
                mid = Math.max(n2, n3);
                min = Math.min(n2, n3);
            } else if (max == n2) {
                mid = Math.max(n1, n3);
                min = Math.min(n1, n3);
            } else {
                mid = Math.max(n1, n2);
                min = Math.min(n1, n2);
            }
            
            // 피타고라스 정리에 따라 직각 삼각형 판별
            if (max * max == mid * mid + min * min) {
                sb.append("right\n");
            } else {
                sb.append("wrong\n");
            }
        }
        System.out.print(sb);
        sc.close();
    }
}
