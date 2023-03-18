import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * boj_17825 주사위 윷놀이 골드2
 * 
 * @author elder
 *
 */
public class boj_17825 {

	static class Node {
		int num;
		Node next;
		Node next_special = null;

		public Node(int num, Node next) {
			super();
			this.num = num;
			this.next = next;
		}

		public Node(int num) {
			super();
			this.num = num;
		}

		public Node(int num, Node next, Node next_special) {
			super();
			this.num = num;
			this.next = next;
			this.next_special = next_special;
		}

		public Node move(int target_cnt, int cnt) {
			if (target_cnt == cnt) {
				return this;
			}

			if (next == null) {
				return this;
			}

			if (cnt == 0 && next_special != null) {
				return next_special.move(target_cnt, cnt + 1);
			} else {
				return next.move(target_cnt, cnt + 1);
			}
		}
	}

	static Node[] players;
	static int Score = Integer.MIN_VALUE;
	static int[] dice_10;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// Integer.parseInt(st.nextToken());

		Node department = new Node(0);
		//
		Node node_40 = new Node(40, department);
		Node node_35 = new Node(35, node_40);
		Node node_30 = new Node(30, node_35);
		Node node_25 = new Node(25, node_30);
		//
		Node node_19 = new Node(19, node_25);
		Node node_16 = new Node(16, node_19);
		Node node_13 = new Node(13, node_16);
		//
		Node node_24 = new Node(24, node_25);
		Node node_22 = new Node(22, node_24);
		//
		Node node_26 = new Node(26, node_25);
		Node node_27 = new Node(27, node_26);
		Node node_28 = new Node(28, node_27);
		//

		Node node_38 = new Node(38, node_40);
		Node node_36 = new Node(36, node_38);
		Node node_34 = new Node(34, node_36);
		Node node_32 = new Node(32, node_34);
		Node node_30_s = new Node(30, node_32, node_28);
		//

		Node node_28_2 = new Node(28, node_30_s);
		Node node_26_2 = new Node(26, node_28_2);
		Node node_24_2 = new Node(24, node_26_2);
		Node node_22_2 = new Node(22, node_24_2);
		Node node_20_s = new Node(20, node_22_2, node_22);

		Node node_18 = new Node(18, node_20_s);
		Node node_16_2 = new Node(16, node_18);
		Node node_14 = new Node(14, node_16_2);
		Node node_12 = new Node(12, node_14);

		Node node_10_s = new Node(10, node_12, node_13);
		Node node_8 = new Node(8, node_10_s);
		Node node_6 = new Node(6, node_8);
		Node node_4 = new Node(4, node_6);
		Node node_2 = new Node(2, node_4);
		Node node_start = new Node(0, node_2);
		//

		// init
		players = new Node[4];
		Arrays.fill(players, node_start);
		Score = 0;
		dice_10 = new int[10];
		for (int i = 0; i < 10; i++) {
			dice_10[i] = Integer.parseInt(st.nextToken());
		}

		//
		dfs(0, 0);

		System.out.println(Score);
	}

	private static void dfs(int depth, int score) {
		if (depth == 10) {
			Score = Math.max(Score, score);
			return;
		}

		outer: for (int i = 0; i < players.length; i++) {
			// 도착한 말이면 보내지 않기
			if (players[i].next == null) {
				continue;
			}

			// 해당칸에 말이 있는지 확인하기
			Node node = players[i].move(dice_10[depth], 0);
			for (int j = 0; j < players.length; j++) {
				if (j != i) {
					if (node == players[j] && node.next != null) {
						continue outer;
					}
				}
			}

			// 문제가 없으면 보내기
			Node node_back = players[i];
			players[i] = node;
			dfs(depth + 1, score + node.num);
			players[i] = node_back;
		}

	}

}
