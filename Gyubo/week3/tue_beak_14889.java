import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class tue_beak_14889 {

    private static final Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] table = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 입력 종료

        // 조합을 이용해 절반 이전값은 스타트 팀,
        // 이후값은 링크 팀으로 구분
        // 구분을 위한 배열생성
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        boolean[] visited = new boolean[n];
        List<Integer[]> combinations = new ArrayList<>();
        int middleValue = n / 2;
        combination(arr, visited, middleValue, 0, combinations, true);

        List<Integer[]> startTeamList = new ArrayList<>();
        List<Integer[]> linkTeamList = new ArrayList<>();

        ArrayList<Integer> score = new ArrayList<>();
        for (int i = 0; i < combinations.size() / 2; i++) {
            // 초기화
            startTeamList.clear();
            linkTeamList.clear();

            Integer[] start = Arrays.copyOf(combinations.get(i), middleValue);
            combination(start, new boolean[middleValue], 2, 0, startTeamList, false);
            Integer[] link = Arrays.copyOfRange(combinations.get(i), middleValue, n);
            combination(link, new boolean[middleValue], 2, 0, linkTeamList, false);

            int startTeamScore = 0;
            int linkTeamScore = 0;
            for (int j = 0; j < startTeamList.size(); j++) {
                Integer[] startIndex = startTeamList.get(j);
                startTeamScore += table[startIndex[0]][startIndex[1]] + table[startIndex[1]][startIndex[0]];

                Integer[] linkIndex = linkTeamList.get(j);
                linkTeamScore += table[linkIndex[0]][linkIndex[1]] + table[linkIndex[1]][linkIndex[0]];
            }
            score.add(Math.abs(startTeamScore - linkTeamScore));
        }
        System.out.println(Collections.min(score));
    }

    private static void combination(Integer[] arr, boolean[] visited, int depth, int index, List<Integer[]> db,
            boolean flag) {
        if (depth == 0) {
            if (flag) {
                makeList(arr, visited, db);
            } else {
                makeList2(arr, visited, db);
            }
            return;
        }
        for (int i = index; i < arr.length; i++) {
            visited[i] = true;
            combination(arr, visited, depth - 1, i + 1, db, flag);
            visited[i] = false;
        }
    }

    private static void makeList(Integer[] arr, boolean[] visited, List<Integer[]> db) {
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                deque.addFirst(arr[i]);
            } else {
                deque.addLast(arr[i]);
            }
        }
        Integer[] result = deque.toArray(new Integer[0]);
        db.add(result);
        deque.clear();
    }

    private static void makeList2(Integer[] arr, boolean[] visited, List<Integer[]> db) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                temp.add(arr[i]);
            }
        }
        db.add(temp.toArray(new Integer[0]));
    }
}
