import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] res;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		res = new int[m];
		recursive(1, 0);
		System.out.println(sb.toString());
	} 


	private static void recursive(int pos, int depth) {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				sb.append(res[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		 for (int i = 1; i <= n; i++) {
			 res[depth] = i;
			 recursive(i + 1, depth + 1);
		 }
	}
}