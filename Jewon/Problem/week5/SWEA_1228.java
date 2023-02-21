import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * SWEA_1228 암호문1 D3
 * 
 * @author SSAFY
 *
 */
public class SWEA_1228 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		LinkedList list;
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			list = new LinkedList<Integer>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			int commands = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int times = 0; times < commands; times++) {
				char g = st.nextToken().charAt(0);

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				for (int i = 0; i < y; i++) {
					list.add(x + i, Integer.parseInt(st.nextToken()));
				}

			}
			System.out.print( "#" + test_case + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}

	}

}
