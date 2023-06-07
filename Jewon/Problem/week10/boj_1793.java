import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * 
 * boj_1793 타일링
 * 
 * @author SSAFY
 *
 */
public class boj_1793 {

	static BigInteger[] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		String input = "";
		memo = new BigInteger[251];
		memo[1] = new BigInteger("1");
		memo[2] = new BigInteger("3");
		memo[0] = new BigInteger("1");
		for (int i = 3; i < memo.length; i++) {
			memo[i] = memo[i - 1].add(memo[i - 2].multiply(new BigInteger("2")));
		}

		while (sc.hasNext()) {
			int N = sc.nextInt();
			System.out.println(memo[N]);
		}
//		while ((input = br.readLine()) != null) {
//			int N = Integer.parseInt(input);
//			System.out.println(memo[N]);
//		}

	}

}
