import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 
 * boj_12852 1로 만들기 2 실버1
 * 
 * @author SSAFY
 *
 */
public class boj_12852 {
	static int mincalc;
	static Deque<Integer> list = new ArrayDeque();
	static Deque<Integer> anslist = new ArrayDeque();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		mincalc = N;

		recur(N, 0);
		System.out.println(mincalc);
		
		for (int i = 0; i < mincalc+1; i++) {
			System.out.print(anslist.pop()+ " ");
		}
		
	}

	private static void recur(int n, int calc) {
		// TODO Auto-generated method stub
		list.add(n);
		
		if (n == 1) {
			mincalc = Math.min(mincalc, calc);
			anslist = new ArrayDeque(list);
			return;
		}

		if (calc >= mincalc) {
			return;
		}
		
		// 1. 3으로 떨어지면 3으로 나눔
		if (n % 3 == 0) {
			recur(n / 3, calc + 1);
			list.removeLast();
		}

		// 2. 2로 떨어지면 2로 나눔
		if (n % 2 == 0) {
			recur(n / 2, calc + 1);
			list.removeLast();
		}

		// 3. 1을 뺌
		recur(n - 1, calc + 1);
		list.removeLast();
	}

}
