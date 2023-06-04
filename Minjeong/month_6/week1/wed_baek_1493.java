import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 박스 채우기
public class wed_baek_1493 {
    static class Node implements Comparable<Node> {
        int size;
        int cnt;

        public Node(int size, int cnt) {
            this.size = size;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.size, this.size);
        }
    }
    static List<Node> list = new ArrayList<>();
    static int cnt;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l, w, h, n;
        l = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
            list.add(new Node(a, Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);
        solve(l, w, h);
        if (flag) System.out.println(-1);
        else System.out.println(cnt);
    }

    private static void solve(int l, int w, int h) {
        if (flag) return;
        if (l == 0 || w == 0 || h == 0) return;

        for (Node node: list) {
            if (node.cnt > 0 && l >= node.size && w >= node.size && h >= node.size) {
                node.cnt -= 1;
                cnt++;
                solve(node.size, w - node.size, h);
                if (!flag) solve(l - node.size, w, h);
                if (!flag) solve(node.size, node.size, h - node.size);
                return;
            }
        }

        flag = true;
    }
}
