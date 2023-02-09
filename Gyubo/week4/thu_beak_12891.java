import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class thu_beak_12891 {

    public static void main(String[] args) throws IOException {
        int answer = 0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String input = br.readLine();

        st = new StringTokenizer(br.readLine());
        int[] mask = new int[4];
        for (int i = 0; i < 4; i++) {
            mask[i] = Integer.parseInt(st.nextToken());
        }

        int[][] infos = new int[s + 1][4];
        for (int i = 1; i < s + 1; i++) {
            Integer index = map.get(input.charAt(i - 1));
            infos[i] = infos[i - 1].clone();
            infos[i][index]++;
        }

        for (int i = 0; i <= s - p; i++) {
            int startIndex = i;
            int endIndex = i + p;
            boolean flag = false;
            for (int j = 0; j < 4; j++) {
                int currentValue = infos[endIndex][j] - infos[startIndex][j];
                if (currentValue < mask[j]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}