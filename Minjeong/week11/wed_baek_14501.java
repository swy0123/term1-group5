import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class wed_baek_14501 {

    static class Node {
        int t;
        int p;

        public Node(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] arr = new Node[n + 2];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new Node(a, b);
        }
        arr[n + 1] = new Node(0, 0);

        int[] res = new int[n + 2];

        for (int i = 1; i <= n + 1; i++) {
            for (int j = 1; j < i; j++) {
                if (j + arr[j].t - 1 < i) {
                    res[i] = Math.max(res[i], res[j] + arr[j].p);
                }
            }
        }
        System.out.println(res[n + 1]);
    }
}