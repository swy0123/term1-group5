import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class sun_beak_16206 {

    private static final int TARGET_LENGTH = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> cakesList = new ArrayList<>();
        List<Integer> restList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int currentValue = Integer.parseInt(st.nextToken());
            if (currentValue % 10 == 0) {
                cakesList.add(currentValue);
                continue;
            }
            restList.add(currentValue);
        }

        Collections.sort(cakesList);
        cakesList.addAll(restList);

        Integer[] cakes = cakesList.toArray(new Integer[0]);

        int answer = 0;
        int currentCakeIndex = 0;
        while (true) {
            if (currentCakeIndex == n || m == 0) {
                break;
            }

            if (cakes[currentCakeIndex] > 10) {
                cakes[currentCakeIndex] -= 10;
                m -= 1;
                answer++;
                continue;
            }

            if (cakes[currentCakeIndex] < 10) {
                currentCakeIndex++;
                continue;
            }

            if (cakes[currentCakeIndex] == 10) {
                answer++;
                currentCakeIndex++;
            }
        }

        // 남은것 중에서 10개인거 확인
        for (int i = currentCakeIndex; i < cakes.length; i++) {
            if (cakes[i] == 10) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
