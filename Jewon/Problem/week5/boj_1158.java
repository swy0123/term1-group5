import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * boj_1158 요세푸스 문제 실버4
 * @author SSAFY
 *
 */
public class boj_1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		int cnt = 1;
		int idx = (K-1);
		
		System.out.print("<" + list.get(idx));
		list.remove(idx);
		
		while(cnt != N) {
			idx += (K-1);
			idx %= list.size();
			System.out.print(", " +list.get(idx) );
			list.remove(idx);
			
			cnt++;
		}
		System.out.print(">");
	}

}
