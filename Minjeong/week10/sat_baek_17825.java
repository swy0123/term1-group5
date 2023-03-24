import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주사위 윷놀이
public class sat_baek_17825 {
    static class Node {
        int line;
        int pos;
        boolean finished;
    }
    static int[] dice = new int[10];
    static int[][] map = new int[5][];
    static Node[] nodes = new Node[4];
    static int res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++) dice[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) nodes[i] = new Node();

        map[0] = new int[21];
        map[1] = new int[4];
        map[2] = new int[3];
        map[3] = new int[4];
        map[4] = new int[4];
        for (int i = 0; i < 21; i++) map[0][i] = i * 2;
        for (int i = 0; i < 4; i++) map[1][i] = i * 3 + 10;
        for (int i = 0; i < 3; i++) map[2][i] = i * 2 + 20;
        for (int i = 1; i < 4; i++) map[3][i] = 30 - i - 1; map[3][0] = 30;
        for (int i = 0; i < 4; i++) map[4][i] = i * 5 + 25;

        solve(0, 0);
        System.out.println(res);
    }

    private static void solve(int totalScore, int cnt) {
        if (cnt == 10) {
            res = Integer.max(res, totalScore);
            return;
        }

        boolean flag = true;
        for (Node node : nodes) {
            if (node.finished) continue;
            flag = false;
            int tmpLine = node.line;
            int tmpPos = node.pos;

            node.pos += dice[cnt];
            if (node.pos < map[node.line].length) {
                if (node.line == 0 && node.pos != 0
                        && map[0][node.pos] <= 30
                        && map[0][node.pos] % 10 == 0) {
                    node.line = map[0][node.pos] / 10;
                    node.pos = 0;
                }
                if (check(node)) solve(totalScore + map[node.line][node.pos], cnt + 1);
            }
            else {
                if (node.line == 0 || node.line == 4
                        || node.pos - map[node.line].length >= map[4].length) {
                    node.finished = true;
                    solve(totalScore, cnt + 1);
                    node.finished = false;
                }
                else {
                    node.pos -= map[node.line].length;
                    node.line = 4;
                    if (check(node)) solve(totalScore + map[node.line][node.pos], cnt + 1);

                }
            }
            node.pos = tmpPos;
            node.line = tmpLine;
        }
        if (flag) solve(totalScore, 10);
    }

    private static boolean check(Node node) {
        for (Node other: nodes) {
            if (other.finished || node == other) continue;
            if (map[node.line][node.pos] == map[other.line][other.pos]
                    && map[other.line][other.pos] == 40) return false;
            if (node.line == other.line && node.pos == other.pos) return false;
        }
        return true;
    }
}