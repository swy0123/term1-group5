import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
class Pair {
    int x;
    int y;
 
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    private static int[][] del = { {0, 1}, {0, -1}, {1, 0}, {-1, 0}, 
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1} };
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int testCase = 1; testCase <= T; testCase++) {
            String s = br.readLine();
            st = new StringTokenizer(s);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n];
            int[] stoneCnt = {2, 2};
            int half = n / 2;
            arr[half - 1][half - 1] = arr[half][half] = 2;
            arr[half - 1][half] = arr[half][half - 1] = 1;
 
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken()) - 1;
                int x = Integer.parseInt(st.nextToken()) - 1;
                int stone = Integer.parseInt(st.nextToken());
                int opposite;
 
                arr[x][y] = stone;
                stoneCnt[stone - 1] += 1;
 
                if (stone == 1) opposite = 2;
                else opposite = 1;
 
                Queue<Pair> q = new LinkedList<>();
                for (int j = 0; j < 8; j++) {
                    out: for(int k = 1; k < n; k++) {
                        int dx = x + del[j][0] * k;
                        int dy = y + del[j][1] * k;
                        if (dx < 0 || dx >= n || dy < 0 || dy >= n) break;
                        if (arr[dx][dy] == 0) break;
                        if (arr[dx][dy] == opposite) continue;
                        if (arr[dx][dy] == stone) {
                            for(int z = 1; z < k; z++) {
                                q.add(new Pair(x + del[j][0] * z, y + del[j][1] * z));
                            }
                            break out;
                        }
                    }
                }
 
                while (!q.isEmpty()) {
                    Pair p = q.poll();
                    if (arr[p.x][p.y] != stone) {
                        arr[p.x][p.y] = stone;
                        stoneCnt[stone - 1] += 1;
                        stoneCnt[opposite - 1] -= 1;
                    }
                }
            }
             
            System.out.println("#" + testCase + " " + stoneCnt[0] + " " + stoneCnt[1]);
        }
    }
}