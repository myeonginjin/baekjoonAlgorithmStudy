import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        ArrayList<HashSet<Integer>> a = new ArrayList<>();

        for (int i = 0; i<9; i++) a.add(new HashSet<>());
        
        a.get(1).add(N);
        if(number==N) return 1;
        
        
        for (int i = 2; i<=8; i++) {
            HashSet<Integer> hs = a.get(i); //N을 i번 써서 만들 수 있는 숫자들의 집합
            
            for (int j = 1; j<=i; j++) {
                
                // i번 집합을 구성할 수 있는, j번 집합과 j-i번 집합
                HashSet<Integer> h1 = a.get(j);
                HashSet<Integer> h2 = a.get(i - j);
                
                //j번 집합과 j-i번 집합의 원소를 사칙연산
                for (int t1 : h1) {
                    
                    for (int t2 : h2) {
                        
                        hs.add(t1 + t2);
                        if(t1!=0 && t2!=0) hs.add(t1 / t2);
                        hs.add(t1 * t2);
                        hs.add(t1 - t2);
                    }
                }
            }
            
            //단순이 N을 이어붙여서 만듦
            hs.add( Integer.parseInt(  String.valueOf(N).repeat(i)  ));
            
            if(hs.contains(number)) {
                return i;
            }
        }
        
    
        return -1;
    }
}