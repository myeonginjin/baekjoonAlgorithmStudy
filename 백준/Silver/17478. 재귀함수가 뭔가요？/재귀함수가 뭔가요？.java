import java.util.*;
import java.util.prefs.BackingStoreException;
import java.io.*;


public class Main {
	public static StringBuilder sb = new StringBuilder();
	
	public static void backT(int n, int cnt) {
		
		if(n <= 0) {
			String line = "";
			
			for (int i = 0; i<cnt*4; i++) {
				line += "_";
			}
			
			sb.append(line+"\"재귀함수가 뭔가요?\"\n");
			sb.append(line+"\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			sb.append(line+"라고 답변하였지.\n");
			
			return;
		}
		
		String line = "";
		for (int i = 0; i<cnt*4; i++) {
			line += "_";
		}
		
		sb.append(line+"\"재귀함수가 뭔가요?\"\n"+
				line+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n"+
				line+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n"+
				line+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		
		backT(n-1, cnt+1);
		
		line = "";
		for (int i = 0; i<cnt*4; i++) {
			line += "_";
		}
		
		sb.append(line+"라고 답변하였지.\n");
		
		
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		
		backT(n,0);
		
		//sb.append("라고 답변하였지.");
		
		
		System.out.println(sb);
		br.close();
		
		
		
		
	}

}
