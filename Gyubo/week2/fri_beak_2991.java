import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class fri_beak_2991 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int[] visitedTime = new int[3];
		st = new StringTokenizer(br.readLine());
		visitedTime[0] = Integer.parseInt(st.nextToken());
		visitedTime[1] = Integer.parseInt(st.nextToken());
		visitedTime[2] = Integer.parseInt(st.nextToken());

		boolean[] dog1 = new boolean[1000];
		boolean[] dog2 = new boolean[1000];

		makeArr(A, B, dog1, 1);
		makeArr(C, D, dog2, 1);
		
		
		for (int time : visitedTime) {
			int count = 0;
			if (!dog1[time]) {
				count++;
			}
			if (!dog2[time]) {
				count++;
			}
			System.out.println(count);
		}
	}

	private static void makeArr(int A, int B, boolean[] dog1, int index) {
		while (true) {
			for (int j = 0; j < A; j++) {
				index++;
				if (index >= 1000) {
					return;
				}
			}
			for (int j = 0; j < B; j++) {
				dog1[index++] = true;
				if (index >= 1000) {
					return;
				}
			}
		}
	}
}
