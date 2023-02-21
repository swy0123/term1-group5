import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스위치 켜고 끄기
public class mon_beak_1244 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (input == 0) {
                arr[i] = -1;
            } else {
                arr[i] = input;
            }
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            if (student == 1) {
                int input = Integer.parseInt(st.nextToken());
                for (int j = input; j < n + 1; j += input) {
                    arr[j] *= -1;
                }
            }

            if (student == 2) {
                int value = Integer.parseInt(st.nextToken());
                for (int j = 1; j < Integer.MAX_VALUE; j++) {
                    int targetLeft = value - j;
                    int targetRight = value + j;
                    if (targetLeft < 1 || targetRight > n) {
                        break;
                    }
                    if (arr[targetLeft] == arr[targetRight]) {
                        arr[targetLeft] *= -1;
                        arr[targetRight] *= -1;
                    } else {
                        break;
                    }
                }
                arr[value] *= -1;
            }
        }

        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            count++;
            if (count == 21) {
                count = 1;
                System.out.println();
            }
            if (arr[i] == -1) {
                System.out.print(0 + " ");
                continue;
            }
            System.out.print(arr[i] + " ");
        }
    }

}
