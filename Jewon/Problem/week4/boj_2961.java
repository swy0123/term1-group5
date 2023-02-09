import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj_2961 도영이가 만든 맛있는 음식 실버2
 * 
 * @author SSAFY
 *
 */
public class boj_2961 {
	static int[][] arr;
	static boolean[] visit;
	static int minDiff = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		visit = new boolean[N];

		for (int i = 0; i < arr.length; i++) {
			// 0 신맛   , 1 쓴맛
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		powerset(0);
		System.out.println(minDiff);
	}

	private static void powerset(int idx) {
		// TODO Auto-generated method stub
		if (idx == arr.length) {
			if(!visitcheck()){
				return;
			}
			
			int ssinmat = 1;
			int ssunmat = 0;
			for (int i = 0; i < arr.length; i++) {
				if (visit[i]) {
					ssinmat *= arr[i][0];
					ssunmat += arr[i][1];
				}
			}
			
			
			minDiff = Math.min(minDiff, Math.abs(ssinmat - ssunmat));
			
			return;
		}

		visit[idx] = true;
		powerset(idx + 1);

		visit[idx] = false;
		powerset(idx + 1);

	}

	private static boolean visitcheck() {
		for (int i = 0; i < arr.length; i++) {
			if(visit[i] == true) {
				return true;
			}
		}
		return false;
	}

}
