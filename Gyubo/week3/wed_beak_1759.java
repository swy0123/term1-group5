import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class wed_beak_1759 {

	private static final Set<String> vowel = new HashSet<>();

	public static void main(String[] args) throws IOException {

		vowel.add("a");
		vowel.add("e");
		vowel.add("i");
		vowel.add("o");
		vowel.add("u");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int l = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		String[] input = new String[c];
		boolean[] visited = new boolean[c];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; i++) {
			input[i] = st.nextToken();
		}
		Arrays.sort(input);

		combination(input, visited, l, 0);
	}

	private static void combination(String[] arr, boolean[] visited, int depth, int index) {
		if (depth == 0) {
			// 모음조건 자음조건 검사
			int vewelCount = 0;
			int consonantCount = 0;
			for (int i = 0; i < arr.length; i++) {
				if (visited[i]) {
					if (vowel.contains(arr[i])) {
						vewelCount++;
					} else {
						consonantCount++;
					}
				}
			}

			if (vewelCount >= 1 && consonantCount >= 2) {
				printResult(arr, visited);
			}

			return;
		}

		for (int i = index; i < arr.length; i++) {
			visited[i] = true;
			combination(arr, visited, depth - 1, i + 1);
			visited[i] = false;
		}
	}

	private static void printResult(String[] arr, boolean[] visited) {
		// 출력
		for (int i = 0; i < arr.length; i++) {
			if (visited[i]) {
				System.out.print(arr[i]);
			}
		}
		System.out.println();
	}

}
