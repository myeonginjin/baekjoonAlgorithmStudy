import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i<n; i++){
            
            st = new StringTokenizer(br.readLine());
            bw.write((Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())+"\n"));
        }
        bw.flush();
        br.close();
    }
}