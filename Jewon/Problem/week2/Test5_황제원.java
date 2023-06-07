import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test5_황제원 {

	static char[] chars = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
	static String[] strs = { "000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010" };

	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
//		String msg = sc.next();
//		Stack<Character> stk = new Stack<Character>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		char[] ans = new char[T];
		String msg = br.readLine();
		int midx = 0;

		for (int i = 0; i < T; i++) {
			String temp = msg.substring(i * 6, (i + 1) * 6);

			// check
			for (int j = 0; j < strs.length; j++) {
				// 얼마나 틀렸나
				int idx = 0;
				int err = 0;

				while (idx < 6 && err < 2) {
					if (temp.charAt(idx) != strs[j].charAt(idx)) {
						err++;
					}

					idx++;
				}

				// 1개 이하 만 다른가
				if (err < 2) {
					// stk.add(chars[j]);
					ans[midx] = chars[j];
					midx++;
				}

			}

			if (i + 1 != midx) {
				System.out.println(i + 1);
				return;
			}
		}

		// 출력
		for (int i = 0; i < midx; i++) {
			System.out.print(ans[i]);
		}
	}

}