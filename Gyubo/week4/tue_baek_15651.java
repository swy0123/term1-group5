import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class tue_baek_15651 {
	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		permutationWithRepetition(n, 0, new int[m]);

		bw.write(sb.toString());
		bw.close();
	}

	private static void permutationWithRepetition(int n, int depth, int[] results) {
		if (depth == results.length) {
			for (int result : results) {
				sb.append(result);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= n; i++) {
			results[depth] = i;
			permutationWithRepetition(n, depth + 1, results);
		}
	}
}
