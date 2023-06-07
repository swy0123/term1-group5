import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Pair {
	int gend;
	int num;

	public Pair(int gend, int num) {
		this.gend = gend;
		this.num = num;
	}
}

public class Main {
	static int[][] del = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] swc = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) swc[i] = Integer.parseInt(st.nextToken());
		int stuCnt = Integer.parseInt(br.readLine());
		List<Pair> list = new ArrayList<>();
		for (int i = 0; i < stuCnt; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		// 구현
		for (Pair student : list) {
			if (student.gend == 1) transY(student.num, n, swc);
			else transX(student.num, n, swc);
			print(swc, n);
		}
	}

	private static void transY(int num, int n, int[] swc) {
		int idx = 1;
		int nnn = num;
		while(num <= n) {
			if (swc[num] == 1) swc[num] = 0;
			else swc[num] = 1;
			num = nnn *++idx;
		}
	}

	private static void transX(int num, int n, int[] swc) {
		if (swc[num] == 1) swc[num] = 0;
		else swc[num] = 1;
		
		int start, end;
		start = num - 1;
		end = num + 1;
		while(start >= 1 && end <= n) {
			if (swc[start] == swc[end]) {
				if (swc[start] == 1) swc[start] = 0;
				else swc[start] = 1;
				if (swc[end] == 1) swc[end] = 0;
				else swc[end] = 1;
			}
			else break;
			start--;
			end++;
		}
	}
	
	private static void print(int[] swc, int n) {
		for (int i = 1; i <= n; i++) {
			System.out.print(swc[i] + " ");
			if (i % 20 == 0) System.out.println();
		}
		System.out.println();
	}
}