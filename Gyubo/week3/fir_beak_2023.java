import java.util.Scanner;

public class fir_beak_2023 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 2; i < 10; i++) {
			dfs(1, n, i);
		}
	}

	private static void dfs(int currentDetph, int targetDepth, int currentValue) {
		// 현재 숫자 소수 판별
		double divFlag = (int) Math.sqrt(currentValue);
		for (int i = 2; i <= divFlag; i++) {
			if (currentValue % i == 0) {
				return;
			}
		}
		// depth 판별
		if (currentDetph == targetDepth) {
			System.out.println(currentValue);
		}

		
		for (int i = 1; i < 10; i++) {
			currentValue = currentValue * 10 + i;
			dfs(currentDetph + 1, targetDepth, currentValue);
			currentValue = (int) (currentValue / 10);
		}
	}
}
