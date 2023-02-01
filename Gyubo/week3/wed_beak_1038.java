import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class wed_beak_1038 {

	private static final List<Long> results = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		for (int i = 0; i < 10; i++) {
			dfs(i);
		}

		Collections.sort(results);

		if (input >= results.size()) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(results.get(input));
	}

	private static void dfs(long number) {
		results.add(number);
		if (number % 10 == 0) {
			return;
		}

		for (long i = number % 10 - 1; i >= 0; i--) {
			long newValue = number * 10 + i;
			dfs(newValue);
		}
	}

}
