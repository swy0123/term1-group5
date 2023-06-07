import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 월드컵
public class thu_beak_6987 {

    static class Country {

        public int win;
        public int draw;
        public int defeated;

        public Country(int win, int draw, int defeated) {
            this.win = win;
            this.draw = draw;
            this.defeated = defeated;
        }

        public Country() {
            this.win = 0;
            this.draw = 0;
            this.defeated = 0;
        }
    }

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 모든 경기의 경우의 수 구하기
        int[][] match = new int[15][2];
        int count = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                match[count++] = new int[]{i, j};
            }
        }

        for (int tc = 0; tc < 4; tc++) {
            answer = 0;
            st = new StringTokenizer(br.readLine());
            Country[] countries = new Country[6];
            Country[] result = new Country[6];
            for (int i = 0; i < 6; i++) {
                countries[i] = new Country(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()));
                result[i] = new Country();
            }
            dfs(0, countries, result, match);
            System.out.print(answer + " ");
        }
    }

    private static void dfs(int depth, Country[] countries, Country[] result, int[][] match) {
        if (depth == 15) {
            for (int i = 0; i < 6; i++) {
                if (!(countries[i].win == result[i].win && countries[i].draw == result[i].draw
                        && countries[i].defeated == result[i].defeated)) {
                    return;
                }
            }
            answer = 1;
            return;
        }

        int team1 = match[depth][0];
        int team2 = match[depth][1];

        // team1 이 이기는 경우
        result[team1].win++;
        result[team2].defeated++;
        if (countries[team1].win >= result[team1].win) {
            dfs(depth + 1, countries, result, match);
        }
        result[team1].win--;
        result[team2].defeated--;

        // team1 이 비기는 경우
        result[team1].draw++;
        result[team2].draw++;
        if (countries[team1].draw >= result[team1].draw) {
            dfs(depth + 1, countries, result, match);
        }
        result[team1].draw--;
        result[team2].draw--;

        // team1 이 지는 경우
        result[team1].defeated++;
        result[team2].win++;
        if (countries[team1].defeated >= result[team1].defeated) {
            dfs(depth + 1, countries, result, match);
        }
        result[team1].defeated--;
        result[team2].win--;
    }
}
