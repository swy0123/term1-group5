import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sat_swea_2115 {

    private static int capacity;
    private static int answer;
    private static int s1;
    private static int s2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc < testCase + 1; tc++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            capacity = Integer.parseInt(st.nextToken());
            answer = 0;

            int[][] table = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 방문배열을 만들어서 첫번째 벌이 탐색한 곳은 탐색하지 않는다.
            // 모든 경우를 탐색 후 해결 방법 구하기
            boolean[][] visited = new boolean[n][n];
            int[] honey1 = new int[m];
            int[] honey2 = new int[m];
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table.length + 1 - m; j++) {
                    for (int k = 0; k < m; k++) {
                        visited[i][j + k] = true;
                        honey1[k] = table[i][j + k];
                    }
                    // person1의 최대 값 구하기
                    s1 = 0;
                    powerSet1(honey1, 0, new boolean[honey1.length]);
                    // 2번째 사람 탐색 시작
                    for (int a = 0; a < table.length; a++) {
                        for (int b = 0; b < table.length + 1 - m; b++) {

                            boolean flag = false;
                            for (int c = 0; c < m; c++) {
                                honey2[c] = table[a][b + c];
                                if (visited[a][b + c]) {
                                    flag = true;
                                    break;
                                }
                            }
                            // 탐색가능한 위치이다.
                            if (!flag) {
                                s2 = 0;
                                powerSet2(honey2, 0, new boolean[honey1.length]);
                                answer = Math.max(answer, s1 + s2);
                            }
                        }
                    }
                    // 두번째 사람 탐색 종료
                    // 백트래킹
                    for (int k = 0; k < m; k++) {
                        visited[i][j + k] = false;
                    }
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
    }

    private static void powerSet1(int[] honey, int index, boolean[] visited) {
        if (index == honey.length) {
            // 꿀의 값 계산
            int sum = 0;
            for (int i = 0; i < honey.length; i++) {
                if (visited[i]) {
                    sum += honey[i];
                }
            }
            if (capacity < sum) {
                return;
            }

            // 가치 구하기
            int value = 0;
            for (int i = 0; i < honey.length; i++) {
                if (visited[i]) {
                    value += honey[i] * honey[i];
                }
            }
            s1 = Math.max(value, s1);
            return;
        }

        visited[index] = true;
        powerSet1(honey, index + 1, visited);

        visited[index] = false;
        powerSet1(honey, index + 1, visited);
    }

    private static void powerSet2(int[] honey, int index, boolean[] visited) {
        if (index == honey.length) {
            // 꿀의 값 계산
            int sum = 0;
            for (int i = 0; i < honey.length; i++) {
                if (visited[i]) {
                    sum += honey[i];
                }
            }
            if (capacity < sum) {
                return;
            }

            // 가치 구하기
            int value = 0;
            for (int i = 0; i < honey.length; i++) {
                if (visited[i]) {
                    value += honey[i] * honey[i];
                }
            }
            s2 = Math.max(value, s2);
            return;
        }

        visited[index] = true;
        powerSet2(honey, index + 1, visited);

        visited[index] = false;
        powerSet2(honey, index + 1, visited);
    }
}
