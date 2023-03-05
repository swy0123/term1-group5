import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 다리 만들거2
public class sun_beak_17472 {

    static class Vertex implements Comparable<Vertex> {

        int e;
        int cost;

        public Vertex(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.cost - o.cost;
        }
    }

    private static final int[][] vector = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] table = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // bfs를 돌면서 라벨링
        int label = 2;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j] == 1) {
                    bfs(table, i, j, label++);
                }
            }
        }

        Map<Integer, List<Vertex>> graph = new HashMap<>();

        // 가로를 방문하면서 문제가 있는 부분을 검사한다.
        checkCol(table, graph);
        checkRow(table, graph);
        int islandNum = label - 2;

        if (graph.size() != islandNum) {
            System.out.println(-1);
            return;
        }

        // 최소 신장 트리 생성
        PriorityQueue<Vertex> q = new PriorityQueue<>();
        q.addAll(graph.get(2));
        boolean[] visited = new boolean[8];
        visited[2] = true;

        int sum = 0;
        int cnt = 1;
        while (cnt < islandNum && !q.isEmpty()) {
            Vertex p = q.poll();

            if (visited[p.e]) {
                continue;
            }
            visited[p.e] = true;

            sum += p.cost;
            cnt++;
            q.addAll(graph.get(p.e));
        }

        if (cnt != islandNum) {
            System.out.println(-1);
            return;
        }
        System.out.println(sum);
    }

    private static void checkCol(int[][] table, Map<Integer, List<Vertex>> graph) {
        for (int y = 0; y < table.length; y++) {
            int prevIsland = 1;
            int seaCount = 0;
            for (int x = 0; x < table[0].length; x++) {
                // 새로운 땅을 발견했을때
                if (table[y][x] != prevIsland && table[y][x] != 0) {
                    // 이전 섬이 없다면 갱신만
                    if (prevIsland != 1) {
                        if (seaCount > 1) {
                            graph.putIfAbsent(prevIsland, new ArrayList<>());
                            graph.putIfAbsent(table[y][x], new ArrayList<>());
                            graph.get(prevIsland).add(new Vertex(table[y][x], seaCount));
                            graph.get(table[y][x]).add(new Vertex(prevIsland, seaCount));
                        }
                    }
                    prevIsland = table[y][x];
                    seaCount = 0;
                } else if (table[y][x] == prevIsland) {
                    seaCount = 0;
                }
                // 바다를 밟았을 때
                else if (table[y][x] == 0) {
                    seaCount++;
                }
            }
        }
    }

    private static void checkRow(int[][] table, Map<Integer, List<Vertex>> graph) {
        for (int x = 0; x < table[0].length; x++) {
            int prevIsland = 1;
            int seaCount = 0;
            for (int y = 0; y < table.length; y++) {
                // 새로운 땅을 발견했을때
                if (table[y][x] != prevIsland && table[y][x] != 0) {
                    // 이전 섬이 없다면 갱신만
                    if (prevIsland != 1) {
                        if (seaCount > 1) {
                            graph.putIfAbsent(prevIsland, new ArrayList<>());
                            graph.putIfAbsent(table[y][x], new ArrayList<>());
                            graph.get(prevIsland).add(new Vertex(table[y][x], seaCount));
                            graph.get(table[y][x]).add(new Vertex(prevIsland, seaCount));
                        }
                    }
                    prevIsland = table[y][x];
                    seaCount = 0;
                } else if (table[y][x] == prevIsland) {
                    seaCount = 0;
                }
                // 바다를 밟았을 때
                else if (table[y][x] == 0) {
                    seaCount++;
                }
            }
        }
    }

    private static void bfs(int[][] table, int i, int j, int label) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});
        table[i][j] = label;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            for (int d = 0; d < vector.length; d++) {
                int ny = p[0] + vector[d][0];
                int nx = p[1] + vector[d][1];

                if (ny < 0 || nx < 0 || ny >= table.length || nx >= table[0].length) {
                    continue;
                }
                if (table[ny][nx] == 1) {
                    table[ny][nx] = label;
                    q.add(new int[]{ny, nx});
                }
            }
        }
    }
}
