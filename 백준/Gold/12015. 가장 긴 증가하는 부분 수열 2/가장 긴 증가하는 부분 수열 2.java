

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] a;
    static ArrayList<Integer> arr;

    // 올바른 lower_bound 구현
    static int binarySearch(int str, int end, int t) {
        while (str < end) {
            int mid = (str + end) / 2;
            if (arr.get(mid) >= t) { // mid도 후보가 될 수 있음
                end = mid;
            } else {
                str = mid + 1;
            }
        }
        return end;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        arr = new ArrayList<>();
        arr.add(a[0]); // 첫 번째 원소 추가

        for (int i = 1; i < a.length; i++) {
            int t = a[i];
            int idx = binarySearch(0, arr.size(), t);

            if (idx == arr.size()) { // 현재 LIS 길이보다 큰 값이면 추가
                arr.add(t);
            } else { // LIS 길이에 포함되는 위치 값 갱신
                arr.set(idx, t);
            }
        }

        System.out.println(arr.size()); // LIS 길이 출력
    }
}