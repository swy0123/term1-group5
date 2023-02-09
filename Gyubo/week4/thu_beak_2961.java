import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Food {
	public int sour;
	public int bitter;

	public Food(int sour, int bitter) {
		super();
		this.sour = sour;
		this.bitter = bitter;
	}

	@Override
	public String toString() {
		return "Food [bitter=" + bitter + ", sour=" + sour + "]";
	}

}

public class thu_beak_2961 {
	private static int minTasteDiff = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		Food[] foods = new Food[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			foods[i] = new Food(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		powerSet(foods, 0, 0);

		System.out.println(minTasteDiff);
	}

	private static void powerSet(Food[] foods, int visited, int depth) {
		if (depth == foods.length) {
			int sourSum = 1;
			int bitterSum = 0;
			for (int i = 0; i < foods.length; i++) {
				if ((visited & 1 << i) == 0) {
					continue;
				}
				sourSum *= foods[i].sour;
				bitterSum += foods[i].bitter;
			}
			if (sourSum == 1 && bitterSum == 0) {
				return;
			}
			int tasteDiff = Math.abs(sourSum - bitterSum);
			minTasteDiff = Math.min(tasteDiff, minTasteDiff);
			return;
		}
		powerSet(foods, visited | 1 << depth, depth + 1);
		powerSet(foods, visited, depth + 1);
	}
}
