import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다음순열
public class thu_beak_10973 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (permutation(arr)) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            return;
        }
        System.out.println(-1);
    }

    private static boolean permutation(int[] arr) {
        int n = arr.length;

        // 꼭대기 찾기
        int i = n - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            --i;
        }
        if (i == 0) {
            return false;
        }

        // 꼭대기는 i
        int j = n - 1;
        while (arr[i - 1] >= arr[j]) {
            --j;
        }
        // 꼭대기 뒷자리 중에서 꼭대기 바로 앞이랑 바꿀 수 구함 == j
        swap(arr, i - 1, j);
        int k = n - 1;
        while (i < k) {
            swap(arr, i++, k--);
        }
        return true;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
