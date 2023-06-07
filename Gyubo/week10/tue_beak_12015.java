import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열 2
public class tue_beak_12015 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        List<Integer> dp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (dp.get(dp.size() - 1) < arr[i]){
                dp.add(arr[i]);
            }
            else{
                int targetIndex = Collections.binarySearch(dp, arr[i]);
                if (targetIndex < -0){
                    targetIndex = -targetIndex - 1;
                }
                dp.set(targetIndex, arr[i]);
            }
        }
        System.out.println(dp.size());
    }
}
