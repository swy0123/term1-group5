import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

// 배
public class sun_baek_1092 {
    private static class Crain {
        int weightLimit;
        int rotateCnt;

        public Crain(int weightLimit, int rotateCnt) {
            this.weightLimit = weightLimit;
            this.rotateCnt = rotateCnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] weightLimits = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weightLimits[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        Integer[] boxWeights = new Integer[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            boxWeights[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(weightLimits, Collections.reverseOrder());
        Arrays.sort(boxWeights, Collections.reverseOrder());
        Queue<Crain> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            q.offer(new Crain(weightLimits[i], 0));
        }

        int res = 0;
        int cnt = m;
        boolean[] check = new boolean[m];
        while (!q.isEmpty()) {
            boolean flag = false;
            for (int i = 0; i < m; i++) {
                if (!check[i] && q.peek().weightLimit >= boxWeights[i]) {
                    flag = true;
                    check[i] = true;
                    cnt--;
                    break;
                }
            }
            if (!flag) q.poll();
            else {
                q.peek().rotateCnt += 1;
                res = q.peek().rotateCnt;
                q.offer(q.poll());
            }
        }

        if (cnt == 0) System.out.println(res);
        else System.out.println(-1);
    }
}