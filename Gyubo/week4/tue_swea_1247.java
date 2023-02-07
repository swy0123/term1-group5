import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class tue_swea_1247 {
	private static int[] CompanyCoord = new int[2];
	private static int[] HomeCoord = new int[2];
	private static int minValue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < testCase + 1; tc++) {
			minValue = Integer.MAX_VALUE;
			int inputNumber = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			// 회사와 집 입력
			CompanyCoord[0] = Integer.parseInt(st.nextToken());
			CompanyCoord[1] = Integer.parseInt(st.nextToken());
			HomeCoord[0] = Integer.parseInt(st.nextToken());
			HomeCoord[1] = Integer.parseInt(st.nextToken());

			int[][] custumersCoord = new int[inputNumber][2];
			for (int i = 0; i < inputNumber; i++) {
				custumersCoord[i][0] = Integer.parseInt(st.nextToken());
				custumersCoord[i][1] = Integer.parseInt(st.nextToken());
			}

			permutaiton(custumersCoord, new boolean[inputNumber], new int[inputNumber], 0);
			System.out.println("#" + tc + " " + minValue);
		}
	}

	private static void permutaiton(int[][] custumersCoord, boolean[] visited, int[] results, int depth) {
		if (custumersCoord.length == depth) {
			// 거리계산
			int dist = 0;
			// 손님들간의 거리
			for (int i = 1; i < results.length; i++) {
				int[] currentCoord = custumersCoord[results[i]];
				int[] prevCoord = custumersCoord[results[i - 1]];

				dist += Math.abs(currentCoord[0] - prevCoord[0]) + Math.abs(currentCoord[1] - prevCoord[1]);
			}

			// 회사부터 거리
			int[] firstCustumerCoord = custumersCoord[results[0]];
			dist += Math.abs(firstCustumerCoord[0] - CompanyCoord[0])
					+ Math.abs(firstCustumerCoord[1] - CompanyCoord[1]);

			// 집부터 거리
			int[] lastCustumerCoord = custumersCoord[results[results.length - 1]];
			dist += Math.abs(lastCustumerCoord[0] - HomeCoord[0]) + Math.abs(lastCustumerCoord[1] - HomeCoord[1]);

			minValue = Math.min(dist, minValue);
			return;
		}

		for (int i = 0; i < custumersCoord.length; i++) {
			if (visited[i] == true) {
				continue;
			}
			visited[i] = true;
			results[depth] = i;
			permutaiton(custumersCoord, visited, results, depth + 1);
			visited[i] = false;
		}

	}
}
