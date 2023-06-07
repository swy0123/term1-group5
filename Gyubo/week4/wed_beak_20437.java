import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class wed_beak_20437 {

    private static int maxValue;
    private static int minValue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            String inputString = br.readLine();
            int k = Integer.parseInt(br.readLine());
            maxValue = Integer.MIN_VALUE;
            minValue = Integer.MAX_VALUE;

            HashMap<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();

            for (int i = 0; i < inputString.length(); i++) {
                char key = inputString.charAt(i);
                map.putIfAbsent(key, new ArrayList<Integer>());
                map.get(key).add(i);
            }

            boolean flag = false;
            for (List<Integer> lst : map.values()) {
                if (lst.size() >= k) {
                    flag = true;
                    // 요소 하나하나 탐색하면서 거리 구하기
                    calDistElement(lst, k);
                }
            }
            if (flag) {
                sb.append(minValue + 1);
                sb.append(" ");
                sb.append(maxValue + 1);
                sb.append("\n");
            } else {
                sb.append(-1);
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
    }

    private static void calDistElement(List<Integer> lst, int k) {
        int dist = k - 1;
        for (int i = dist; i < lst.size(); i++) {
            maxValue = Math.max(lst.get(i) - lst.get(i - dist), maxValue);
            minValue = Math.min(lst.get(i) - lst.get(i - dist), minValue);
        }
    }
}