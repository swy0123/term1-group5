import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		res = new int[m];
		recursive(0, new boolean[n + 1]);
	} 


	private static void recursive(int idx, boolean[] v) {
		if (idx == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
			return;
		}
		
		 for (int i = 1; i <= n; i++) {
			 if (v[i] == false) {
				 v[i] = true;
				 res[idx] = i;
				 recursive(idx + 1, v);
				 v[i] = false;
			 }
		 }
	}
}