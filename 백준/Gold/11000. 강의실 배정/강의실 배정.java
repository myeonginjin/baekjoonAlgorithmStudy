import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/input_11000"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> {return o1[0] - o2[0];} );
        
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int Si = Integer.parseInt(st.nextToken());
            int Ti = Integer.parseInt(st.nextToken());
            pq.offer(new int[] { Si, Ti });
        }
        
        // 최소 힙 사용
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        rooms.offer(pq.poll()[1]); // 첫 번째 수업의 종료 시간을 넣음
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int start = current[0];
            int end = current[1];
            
            // 가장 빨리 끝나는 강의실을 찾음
            if (rooms.peek() <= start) {
                rooms.poll(); // 기존 강의실의 종료 시간을 업데이트
            }
            
            rooms.offer(end); // 새로운 강의실을 할당
        }
        
        // 필요한 강의실의 개수는 강의실의 크기(강의실 개수)
        System.out.println(rooms.size());
    }
}